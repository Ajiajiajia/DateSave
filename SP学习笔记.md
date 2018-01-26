# SharedPreference存储数据

+ 适用范围：保存少量的数据，且这些数据的格式非常简单：字符串型、基本类型的值。比如应用程序的各种配置信息（如是否打开音效、是否使用震动效果、小游戏的玩家积分等），解锁口 令密码等
+ 保存 基于 XML文件 存储的 key-value键值对数据，通常用来存储一些简单的配置信息。
+ SharedPreferences对象本身只能获取数据而不支持存储和修改
+ 存储修改是通过SharedPreferences.edit()获取的内部接口Editor对象实现

## 获取实例

+ SharedPreferences本身是一 个接口，程序无法直接创建SharedPreferences实例，只能通过Context提供的getSharedPreferences(String name, int mode)方法来获取SharedPreferences实例
	+ name表示要操作的xml文件名
	+ 第二个参数具体如下：
		+ Context.MODE_PRIVATE: 指定该SharedPreferences数据只能被本应用程序读、写。
		+ Context.MODE_WORLD_READABLE:  指定该SharedPreferences数据能被其他应用程序读，但不能写。
		+ Context.MODE_WORLD_WRITEABLE:  指定该SharedPreferences数据能被其他应用程序读，写

```
//获取SharedPreferences对象
SharedPreference myPreference=getSharedPreferences("myPreference", Context.MODE_PRIVATE);
```

## Editor

+ SharedPreferences.Editor clear():清空SharedPreferences里所有数据
+ SharedPreferences.Editor putXxx(String key , xxx value): 向SharedPreferences存入指定key对应的数据，其中xxx 可以是boolean,float,int等各种基本类型据
+ SharedPreferences.Editor remove(): 删除SharedPreferences中指定key对应的数据项
+ boolean commit(): 当Editor编辑完成后，使用该方法提交修改

```
//像SharedPreference中写入数据需要使用Editor
Editor editor = myPreference.edit();
 
 //存入键值对数据，注意此处的put[type]("key",value);
 editor.putString("STRING_KEY", "string");
 editor.putInt("INT_KEY", 0);
 editor.putBoolean("BOOLEAN_KEY", true);

```

## 读取

+ getTYPE("key",defaultvalue),第一个参数是要获取的key，第二个参数是默认值，是当没有为这个key保存值的时候使用。

```
SharedPreference myPreference=getSharedPreferences("myPreference", Context.MODE_PRIVATE);

String name=preferences.getString("name", "defaultname");

String age=preferences.getString("name", "暂无");
String age=preferences.getInt("age", 0);
String age=preferences.getBoolean("isRead", false);

```

### 读写其他应用的SharedPreferences

+ 1、在创建SharedPreferences时，指定MODE_WORLD_READABLE模式，表明该SharedPreferences数据可以被其他程序读取
+ 2、创建其他应用程序对应的Context:

```
Context pvCount = createPackageContext("com.tony.app", Context.CONTEXT_IGNORE_SECURITY);
这里的com.tony.app就是其他程序的包名
```

+ 3、使用其他程序的Context获取对应的SharedPreferences

```
SharedPreferences read = pvCount.getSharedPreferences("lock", Context.MODE_WORLD_READABLE);

```

## 提交保存

+ apply和commit都是提交保存，区别在于apply是异步执行的，不需要等待。不论删除，修改，增加都必须调用apply或者commit提交保存。
+ 关于更新：如果已经插入的key已经存在。那么将更新原来的key。
+ 应用程序一旦卸载，SharedPreference也会被删除。

```
//提交保存
//editor.apply();
editor.commit();
```

## 检索

```
SharedPreference myPreference=getSharedPreferences("myPreference", Context.MODE_PRIVATE);

//检查当前键是否存在
boolean isContains=myPreference.contains("key");

//使用getAll可以返回所有可用的键值
//Map<String,?> allMaps=myPreference.getAll();
```

## 与SQLite进行对比

SharedPreferences对象与SQLite数据库相比，免去了创建数据库，创建表，写SQL语句等诸多操作，相对而言更加方便，简洁。但是SharedPreferences也有其自身缺陷，比如其职能存储boolean，int，float，long和String五种简单的数据类型，比如其无法进行条件查询等。所以不论SharedPreferences的数据存储操作是如何简单，它也只能是存储方式的一种补充，而无法完全替代如SQLite数据库这样的其他数据存储方式。


# 新收获

shared preferences对象本身只能获取数据，而不支持存储和修改，存储和修改都是通过Editor对象实现

+ boolean
+ int 
+ float
+ long
+ String

### 不论SharedPreferences的数据存储操作是如何的简单，他也只能是存储方式的一种补充，而无法完全替代QSQLite数据库等其他数据存储方式

# 保存数据

```
SharedPreferencesUtils.setParam(this, "String", "xiaanming");  
SharedPreferencesUtils.setParam(this, "int", 10);  
SharedPreferencesUtils.setParam(this, "boolean", true);  
SharedPreferencesUtils.setParam(this, "long", 100L);  
SharedPreferencesUtils.setParam(this, "float", 1.1f);

```

# 获取方法

```
SharedPreferencesUtils.getParam(TimerActivity.this, "String", "");                                                                                        SharedPreferencesUtils.getParam(TimerActivity.this, "int", 0);  
SharedPreferencesUtils.getParam(TimerActivity.this, "boolean", false);  
SharedPreferencesUtils.getParam(TimerActivity.this, "long", 0L);  
SharedPreferencesUtils.getParam(TimerActivity.this, "float", 0.0f);
```


# 重大收获！！

如果返回的数据是多种类型的话那么就需要使用到object

#  Object--对象

![虽然我现在暂时还看不懂](http://blog.csdn.net/geofferysun/article/details/52796803)

+ Java中唯一没有父类的类，是类层次的根
+ Java中所有的类（包括标准容器类，比如数组）从根本上都继承自这个类，也就是直接或间接继承Object


## 01 euqals()
```
public boolean equals(Object obj) {
    return (this == obj);
}
```

+ equals的作用意义，是用来比较两个对象是否相等
+ 程序上来看，两个对象是否是同一个对象，即比较其内存地址
+ 只有当继承Object的类覆写（override）了equals()方法之后，继承类实现了用equals()方法比较两个对象是否相等，才可以说equals()方法与==的不同。

### ==比较的就是对象的内存地址

### 并且覆写equals()方法时，应该同时覆写hashCode()方法，反之亦然

## 02 hashCode()

```
public int hashCode() {
    int lockWord = shadow$_monitor_;
    final int lockWordStateMask = 0xC0000000;  // Top 2 bits.
    final int lockWordStateHash = 0x80000000;  // Top 2 bits are value 2 (kStateHash).
    final int lockWordHashMask = 0x0FFFFFFF;  // Low 28 bits.
    if ((lockWord & lockWordStateMask) == lockWordStateHash) {
        return lockWord & lockWordHashMask;
    }
    return System.identityHashCode(this);
}
```

这个方法返回一个整型值（hash code value），如果两个对象被equals()方法判断为相等，那么它们就应该拥有同样的hash code。Object类的hashCode()方法为不同的对象返回不同的值，Object类的hashCode值表示的是对象的地址。

+ 如果equals()判断两个对象相等，那么它们的hashCode()方法应该返回同样的值。
+ 并没有强制要求如果equals()判断两个对象不相等，那么它们的hashCode()方法就应该返回不同的值。即，两个对象用equals()方法比较返回false，它们的hashCode可以相同也可以不同。但是，应该意识到，为两个不相等的对象产生两个不同的hashCode可以改善哈希表的性能。

## SharedPreferences中所使用到的Object 

![](http://oz3rf0wt0.bkt.clouddn.com/18-1-25/45679022.jpg)

+ 预先不知道用户存入是什么健值对应的数据类型，所以只能以对象的方式获取，然后将此object对象instanceof去匹配类型，匹配成功后进行强制类型转换，然而！！！不要以为输出这样就可以了，注意！注意！这个函数是以一个object的形式返回的，所以！！！！！！！！！！你最终的到的还是一个经过强制类型转换后的object类型，是不是感觉有种“又回到最初的起点的感觉”
+ 其实存入的时候，就已经使用过instanceof对健值对应的类型进行了判断，并且强制类型转换后存入健值对，所以，其实，你完全可以不用这个复杂的工具类进行转换，直接对key进行 getXXX的操作，我觉得会更简单 In my opinion 嘻嘻


1.工具类里面的方法

![](http://oz3rf0wt0.bkt.clouddn.com/18-1-25/97387171.jpg)

2.错误方法

![](http://oz3rf0wt0.bkt.clouddn.com/18-1-25/55014588.jpg)

3.正确的两种方法--强制类型转换

![](http://oz3rf0wt0.bkt.clouddn.com/18-1-25/99831883.jpg)

### 这里最最最值得学的方法应该是toast方法。toast后面括号内应该跟的是什么

+ 之前一直在 研究toast后面写什么，其实像这样获取参数进行上传就行


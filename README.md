# First__Line_Code_2

①

在重写 onOptionsItemSelected（）方法时发现如果使用的是switch,则不能正常识别R.id.xxx:

```java
 //点击菜单项的触发事件
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mune_enter:
                Toast.makeText(this, "点击选项一", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mune_setting:
                Toast.makeText(this, "点击选项二", Toast.LENGTH_SHORT).show();
 
                break;
            case R.id.mune_out:
                Toast.makeText(this, "点击选项三", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

————————————————

                            版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
                        
原文链接：https://blog.csdn.net/shanhe_yuchuan/article/details/135276876
```



解决方法:

参考链接:[【Android基于JAVA8的switch报错】Constant expression required 我猜很多人都遇到了……_android studio 出现constant expression required错误-CSDN博客](https://blog.csdn.net/cantclimbthetree/article/details/133888102)

##将switch替换为if else;

替换快捷键：

[Android Studio快捷键switch case 轻松转换为if else_switch case改为if-CSDN博客](https://blog.csdn.net/mp624183768/article/details/89916739)

选中switch之后，点击Alter+Enter;



问题出现的原因：

JDK17版本以下都可以，只有17不行，因为JDK17中switch语句的条件表达式支持使用枚举类型，而这个特性还没有被支持。用8和11都没错。

要不用if-esle替换，要不别用jdk17，要不用枚举；

②


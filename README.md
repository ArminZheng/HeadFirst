# 设计模式
## 观察者模式 Observer
- 最重要的代码是
  - 观察者接口Observer实现类的构造方法会传入主题，并用这个主题注册自身：
```java
public CurrentConditionsDisplay(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
}
```
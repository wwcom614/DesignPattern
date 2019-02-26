编码一定要懂设计模式，可以提高软件系统的可复用性和可维护性，降低类的复杂性，减少类间耦合性，降低修改带来的风险。
引入设计模式常常会增加程序复杂性，不是任何时候编码都严格遵守设计模式，而是讲究结合场景取舍，适度使用不是全部遵守。   
工作过程中不经意间经常使用，但未总结过，抽时间用代码表达一下，同时让自己再加深下理解。      
1.七种设计原则：开闭原则、依赖倒置原则、单一职责原则、接口隔离原则、迪米特原则、里氏替换原则、合成复用原则。   
2.创建型设计模式：工厂方法、抽象工厂、建造者、单例常用，原型模式相对不常用。   
3.结构型设计模式：适配器、装饰者、代理、外观常用，桥接、享元相对常用，组合模式不常用。  
4.行为型设计模式：策略、责任链、模板方法、状态常用，观察者、迭代器会使用已封装好的，备忘录、中介者、命令、访问者不常用，解释器一般用不到。   

##  设计原则   
### 开闭原则   
一个软件实体，如类、模块、方法对扩展开放，对修改关闭。     
抽象框架对修改关闭，细节实现允许扩展。   
- principle.openclose：  
1.IGetItemInfo：为一个获取商品信息操作，定义了一个接口。  
2.ItemInfoImpl implements IGetItemInfo：IGetItemInfo接口的实现类。   
3.DiscountItemInfoImpl extends ItemInfoImpl：新需求是获取打折商品信息，使用ItemInfoImpl子类实现。   
抽象框架对修改关闭：不改接口和现有实现类。   
细节实现允许扩展：增加一个子类继承现有实现类完成功能。      
4.DiscountItemInfoImplTest：测试验证功能OK。   

### 依赖倒置原则     
上层模块不依赖下层模块，二者都依赖抽象来解决。   
其实就是常说的面向接口编程，而不是面向实现编程。   
- principle.dependencyreverse：  
1.IBuyItem：为商品的购买操作，定义了一个接口。   
2.ItemKeyboard和ItemMouse：IBuyItem接口的实现类。    
3.Customer1：应用上层面向接口编程方法1，接口作为入参注入。   
4.Customer2：应用上层面向接口编程方法2，接口使用构造器注入。   
5.Customer3：应用上层面向接口编程方法3，接口使用setter方法注入。      
6.CustomerBuyItemTest：测试验证上述3种方法功能OK。  

### 单一职责原则         
一个类/接口/方法只负责一项职责，避免存在多于一个导致类变更的原因。   
一般在接口和方法使用时遵循单一职责，类方面受关联和项目进度因素等，有时可能会不能遵守。   
- principle.singleresponsibility    
1.类的单一职责：  
鸟有多种，从行动分类有飞、游泳、跑的鸟，分别定义了FlyBird和SwimBird类，测试类分别实例化不同的类来做不同的事情。   
2.接口的单一职责：   
购买商品和退订商品是不同的行为，内部包含不同的操作，分别定义了IBuyItem和IRefundItem两种接口，Customer类实现这2个接口。   
3.方法的单一职责：   
Customer类中，addItemToShopCart和delItemFromShopCart是用户不同的操作，方法分离。    

### 接口隔离原则      
创建时尽量细化接口，接口中方法尽量少(适度，过大过小都不好)，不能建立庞大臃肿的接口。   
其实就是细粒度接口便于类使用时组装，但粗粒度接口类使用时无法拆分。     
-  principle.interfacesegregation   
1.IAnimalCommanAction接口定义了动物通用的吃、喝方法，IAnimalFly定义了动物飞行方法，IAnimalSwim定义了动物游泳方法。   
2.Dog implements IAnimalSwim,IAnimalCommanAction，dog不会飞，所以不需要实现IAnimalFly。   

### 迪米特原则   
一个对象对其他对象保持最少的了解--最少知道原则。尽量降低类之间的耦合，例如使用private，protected等。  
可以理解为只和朋友交流，不和陌生人说话。而朋友是指的该类的成员变量、方法的入参和出参的类。方法体内部的类是陌生人。  
- principle.demeter   
Teacher让Student数下自己学过几门Course。  
Student作为Teacher的入参，是相关朋友。   
但就此事而言，Teacher和Course是无关陌生人。   
所以Teacher类中无Course，Course只在Student中出现。   

### 里氏替换原则      
对开闭原则的补充，子类继承父类的规范，可约束继承泛滥。子类可以扩展父类的功能，但子类不能改变父类原有的功能，入宽出严。
1.子类可以实现父类的抽象方法，但是不能覆盖父类的非抽象方法。   
2.子类中可以增加自己特有的方法。   
3.当子类重载父类的方法时，方法的前置条件(即方法的输入/入参)要比父类方法的输入参数更宽松，此时执行的是父类方法。    
4.当子类实现父类的抽象方法时(重写/重载/实现抽象方法)，方法的后置条件(即方法的输出/返回值)要比父类更严格或相等。

### 合成复用原则    
功能复用时，尽量使用对象组合(contains a)/聚合(has a)，而不是使用继承(is a)。   


   
## 创建型设计模式   
### 创建型：简单工厂模式       
由一个工厂对象决定创建出哪一种产品的实例。     
调用方只需要传一个参数给简单工厂，即可获取对象而无需关心对象创建细节。   
但其缺点是简单工厂类的职责相对过重，每次增加新产品对象都要修改工厂类判断逻辑，违背了开闭原则。     
所以简单工厂方法不属于设计模式，但它是工厂方法模式和抽象工厂模式的基础。   
如果引入反射，可使得简单工厂在新增产品时不改动，满足开闭原则。  
JDK中的calendar就使用了简单工厂模式。   
-  pattern.creational.simplefactory  
1.产品：产品抽象类Fridge，HaierFridgeImpl和HisenseFridgeImpl都是其具体实现类。  
2.简单工厂类SimpleFactory：用于生产HaierFridgeImpl和HisenseFridgeImpl，对调用方屏蔽创建对象细节。使用了2种方法：参数+判断逻辑方法、类参数+反射方法。   
3.测试类SimpleFactoryTest作为调用方，调用简单工厂类SimpleFactory，分别创建了HaierFridgeImpl和HisenseFridgeImpl的对象。   

### 创建型：工厂方法模式      
-  pattern.creational.factorymethod    
工厂方法模式应对创建一种产品的等级结构场景。  
工厂方法在简单工厂的基础上改进了工厂形态：定义一个接口或抽象类作为工厂方法，让将创建对象的操作推迟到工厂方法的实现类中进行。  
使用了多态+里氏替换原则，符合开闭原则。适用于解决原本需要大量重复代码创建同级多种产品的场景。   
JDK中Collection中的Iterator接口就使用了工厂方法模式，Itr是其具体实现类。  
1.产品：产品抽象类Fridge，HaierFridgeImpl和HisenseFridgeImpl都是其具体实现类。      
2.工厂方法FactoryMethod，定义产品的生产规约但无实现，抽象类(还有要继承的公用类场景使用)或接口(都是独立的方法场景使用)。   
3.工厂方法实现类HaierFactoryMethodImpl和HisenseFactoryMethodImpl。  
4.FactoryMethodImplTest：测试验证功能OK。        

### 创建型：抽象工厂模式    
-  pattern.creational.abstractfactory
抽象工厂模式应对创建一个产品族(多种产品)场景，只有对应产品族(多个产品固定程度较高)的情况下，才需要使用抽象工厂模式。   
工厂方法模式是一种极端情况的抽象工厂模式（即只生产一种产品等级的抽象工厂模式），而抽象工厂模式可以看成是工厂方法模式的一种推广。     
缺点：复杂；经常新增产品等级不合适(例如现有冰箱和TV类产品，新增空调类产品)，违背开闭原则，改动较大。  
JDK中的sql类，以连接为例，有多种数据库产品，产品族是每种数据库产品的连接方法。  
1.产品族：  
(1)产品抽象类Fridge。HaierFridgeImpl和HisenseFridgeImpl都是其具体实现类。      
(2)产品抽象类TV。HaierTVImpl和HisenseTVImpl都是其具体实现类。        
2.抽象工厂AbstractFactory，定义产品族的生产规约但无实现，抽象类(还有要继承的公用类场景使用)或接口(都是独立的方法场景使用)。   
3.抽象工厂实现类：  
(1)HaierAbstractFactoryImpl实现了生产海尔冰箱和电视的方法。   
(2)HisenseAbstractFactoryImpl实现了生产海信冰箱和电视的方法。    
4.AbstractFactoryTest：测试验证功能OK。 

### 创建型：建造者模式    
建造者模式调用方关注部件组装及其组装顺序，工厂模式直接生产产品不存在部件及顺序。      
JDK中的StringBuilder和StringBuffer的append。    
-  pattern.creational.builder   
建造者方式1：  
1.Director.java：指挥者，调用者与建造者之间的桥梁，与调用者沟通建造需求，根据建造需求依赖调用建造者builder组装产品。      
2.Builder.java：建造者，声明产品的公共部件建造方法(接口或抽象类)和获取组装好产品的方法。  
3.ConcreteBuilder1和ConcreteBuilder2：2个具体建造者，具体实现建造者builder接口，组装所需的组件产出对应的产品。   
4.Computer.java：建造者最终将部件组装好后的产出产品。    
建造者方式2：  
ProductBuilder.java：建造者使用return this的方式实现，调用者可以链式调用组装更方便。  
5.BuilderTest.java：对2种方式建造者测试，OK。  

### 创建型：单例模式   
确保某个类只有一个实例，保证全局对象的唯一性。  
private构造方法，1个类确保只实例化1个对象，分懒汉模式、饿汉模式、静态内部类模式、枚举模式。      
要考虑线程安全性、序列化和反序列化时的破坏、反射攻击、原型模式的克隆破坏。  
JDK中的Runtime类就是饿汉单例模式。     
-  pattern.creational.singleton    
1.LazySingletonSynchronized：懒汉单例模式，getInstance静态方法加锁，保证线程安全。相当于锁住整个类，性能不好。  
2.LazySingletonDoubleCheck：懒汉单例模式，双重检测+volatile禁止指令重排序，保证线程安全。     
3.StaticInnerClassSingleton：静态内部类实现单例，线程安全。基于类初始化的延迟加载，Class对象初始化时JVM加锁了，只有一个线程可以实例化。  
4.HungrySingleton：饿汉单例模式，类加载时候就初始化，可以直接定义为final，在类加载完成时完成赋值且不可更改。缺点是如果不用就浪费资源了。  
5.单例模式需要解决序列化和反序列化时的破坏问题：原因是序列化和反序列化时会反射生成新的对象，
定义一个readResolve方法，return自己已实例化的单例对象，而不是返回反射生成新的对象。在HungrySingleton中进行了验证。   
6.单例模式要防范反射攻击：饿汉单例模式和静态内部类单例模式，在类加载时就先实例化了单例对象，所以只要在构造方法加上对象不为空的判断，就可以防反射攻击。      
7.EnumSingleton：枚举类型单例模式，类加载时候就初始化。无序列化和反序列化的破坏问题，自身防反射攻击，所以是单例模式的最佳实践。  
注：在序列化的时候Java仅仅是将枚举对象的name属性输出到结果中，反序列化的时候则是通过java.lang.Enum的valueOf方法来根据名字查找枚举对象，所以可以保证实例化对象唯一。     
8.ContainerSingleton：容器类的单例，根据场景选择：如果不需要考虑线程安全使用HashMap，将多个单例封装到该容器中便于管理。  
9.ThreadLocalSingleton：ThreadLocal的单例模式，在每个Thread内部是单例。      
10.单例模式测试类SingletonTest：  
(1)testSequenceHungrySingleton：模拟序列化和反序列化时对饿汉单例的破坏。        
(2)testReflectHungrySingleton测试：模拟反射攻击饿汉单例模式。    
(3)testReflectStaticInnerClassSingleton测试：模拟反射攻击静态内部类单例模式。    
(4)testSequenceEnumSingleton：模拟序列化和反序列化时对枚举单例的破坏。  
(5)testReflectEnumSingleton测试：模拟反射攻击枚举单例模式。    

### 创建型：原型模式         
目的：需要复制某个复杂对象来获得与该对象一模一样的大量对象实例。      
优势：基于内存中二进制流方式复制，比new一个对象再赋值性能好很多。clone新对象不会调用该类的构造方法。   
注意对象内的引用对象默认是浅拷贝的坑，建议统一处理为深拷贝。  
JDK中的ArrayList、HashMap等都使用了原型模式，implements Cloneable，重写clone方法。  
-  pattern.creational.prototype      
一.原型模式：       
1.Mail.java：假设该对象很大且需要复制，Mail implements Cloneable，重写clone方法。   
2.MailUtil.java：模拟邮件发送，记录每个Mail内容。  
3.PrototypeTest.java测试：for循环(Mail) mail.clone()生成多个Mail克隆对象，通过打印确定的确是复制生成了多个对象，且复制对象未调用构造方法。       
二.原型模式+抽象父类+实现子类：       
1.PrototypeParent.java：如果某个要复制的类有多个且相似，考虑定义一个父类PrototypeParent implements Cloneable。       
2.PrototypeChild.java：定义子类PrototypeChild extends PrototypeParent，然后子类定制实现克隆，符合开闭原则。      
三.原型模式的浅拷贝和浅拷贝：      
1.ShallowClonePerson浅拷贝(坑)、PrototypeTest：  
person进行了浅拷贝，person.clone()将不会对其内部的引用变量date进行拷贝，
导致原型对象person和浅拷贝克隆对象shallowClonePerson使用了相同的引用变量date。   
那么此时对原型对象person的引用变量date赋值，浅拷贝克隆对象shallowClonePerson的引用变量date也被相同赋值了。  
2.DeepClonePerson深拷贝(推荐使用)、PrototypeTest：        
person进行了深拷贝，person.clone()将其内部的引用变量date也进行了拷贝，
原型对象person和浅拷贝克隆对象shallowClonePerson使用的是不同的引用变量date。  
那么此时对原型对象person的引用变量date赋值，浅拷贝克隆对象shallowClonePerson的引用变量date不受影响。  
四.原型模式的克隆方法对单例模式的破坏与防范：  
1.PrototypeTest.java的testCloneDestroySingleton测试方法，反射获取饿汉单例模式内部定义的克隆方法试图破坏单例。    
2.HungrySingleton的防范方法：  
(1)不implements Cloneable  
(2)如果一定要implements Cloneable的话，那么重写clone方法时，不能return super.clone()，而是return getInstance()。  

## 结构型设计模式     
### 结构型：外观模式    
也叫门面模式，facade，封装了内部多个子系统，为外部调用者提供统一接口服务，符合迪米特原则。  
Tomcat中使用了很多facade，例如requestFacade。一些utils工具类也是了外观模式。   

-  pattern.structural.facade    
1.PointsGift：积分兑换礼物类。   
2.内部子系统服务：
(1)StorageService：积分兑换礼物，要先到“库存服务”子系统查看礼物库存是否足够。  
(2)PointsPaymentService：然后还要到“积分支付”子系统查看用户积分是否足够以及扣减积分换礼物。  
(3)PointsPaymentService：如果库存和积分支付都OK，要到“物流服务”子系统发货。   
5.GiftExchangeFacade：礼物兑换外观门面，封装StorageService、PointsPaymentService、PointsPaymentService。  
6.FacadeTest：第三方调用者，不与内部子系统交互，只调用GiftExchangeFacade，实现用户积分兑换礼物。  

### 结构型：装饰者模式     
在不改变原有对象核心功能基础之上，将装饰功能灵活组合动态添加到对象上进行功能扩展，可以实现不同效果，扩展原有对象功能。    
比继承灵活，是继承的有力补充，类和核心功能与装饰功能区分开，符合开闭原则。     
核心实现是将原始对象作为参数传给装饰者的构造器。   
JDK中的IO流就是使用的装饰者模式，能多层参数嵌套调用。  
-  pattern.structural.decorator   
1.AbstractPancake：买个煎饼抽象类。    
2.Pancake extends AbstractPancake：煎饼实体类，继承煎饼抽象类。   
3.AbstractDecorator extends AbstractPancake：装饰器的核心思想，装饰类也继承煎饼抽象类。   
(1)如果装饰类有想让子类都实现的方法，定义一个抽象方法，那么装饰类要定义为抽象类。   
(2)反之，装饰类就定义为一个普通类。      
4.EggDecorator extends AbstractDecorator：加个蛋的装饰类，继承煎饼抽象类。核心是以煎饼抽象类为入参，构造加好蛋的煎饼类。   
5.SausageDecorator extends AbstractDecorator：加个香肠的装饰类，继承煎饼抽象类。核心是以煎饼抽象类为入参，构造加好香肠的煎饼类。      
6.DecoratorTest：装饰类的构造方法以核心抽象类为入参，构造方法装饰处理后，实例化出装饰好的核心抽象类。  

### 结构型：适配器模式   
适配器是在维护阶段才考虑的，目的是将一个已有类的接口转换成调用方期望的另外一个目标接口，让两个接口协同工作，符合开闭原则。   
适配器有2类：   
(1)类适配器：使用类继承实现。   
(2)对象适配器：使用组合实现，符合组合-复用原则，使用委托机制。  
继承和组合都有的前提下，优先选用组合方式，所以优先使用对象适配器。  
JDK中的XmlAdapter对XML的序列化和反序列化使用的就是适配器模式。  
SpringMVC中，DispatcherServlet的doDispatch方法里面就使用了handlerAdapter，适配生成各种不同的handler，
controller是被适配者，有多种，是已有资源，对各种controller实现都有相应的handlerAdapter适配。   
如果handlerAdapter找不到适配的controller，返回false：return (handler instanceof Controller)。   

-  pattern.structural.adapter.classadapter   
类适配器：   
1.Adaptee：已有的被适配者及其已有方法。   
2.ITarget和ConcreteTarget：已有的目标接口及其实现目标类和目标方法。  
3.ClassAdapter：类适配器extends Adaptee implements ITarget，使用类继承实现。使用Adaptee被适配者的方法，实现ITarget目标方法。   
4.ClassAdapterTest：调用方使用适配器的目标方法classAdapter.targetMethod()，无感知的使用Adaptee被适配者的方法，实现了ITarget目标方法。  

-  pattern.structural.adapter.objectadapter       
对象适配器：   
1.Adaptee：已有的被适配者及其已有方法。   
2.ITarget和ConcreteTarget：已有的目标接口及其实现目标类和目标方法。  
3.ObjectAdapter：对象适配器implements ITarget，使用组合实现，符合组合-复用原则，使用委托机制。内部实例化一个Adaptee对象，实现ITarget目标方法。   
4.ObjectAdapterTest：使用适配器的目标方法objectAdapter.targetMethod()，调用方无感知的使用Adaptee被适配者的方法，实现了ITarget目标方法。  

- pattern.structural.adapter.poweradapter   
感觉适配器很像手机充电器，just try directly！  
1.AC220V：家里已有的墙上交流电。  
2.IDC5V：目标转换为5V直流电，才能给手机充电。   
3.PowerAdapter：优先使用对象适配器，implements IDC5V，组合已有220V交流电类AC220V。适配层业务逻辑：使用变压器方法将220V交流电转换为5V直流电。  
4.PowerAdapterTest：使用适配器的目标方法outputDC5V，用户作为调用方，无感知的实现了输入交流电到直流电的适配转换。    

### 结构型：享元模式   
get对象时从对象容器中查询，有则从对象容器中直接get，没有则创建对象并put到对象容器中。   
封装对象复用，使成为最轻量级的类。减少创建对象的数量，从而减少内存的占用，提高性能。   
使用场景：足够多的享元对象可供共享复用时使用。    
享元内部状态：在享元对象内部，享元对象的固定属性，不会随着环境改变而改变的共享部分。     
享元外部状态：在享元对象外部，享元对象的入参，会随着环境改变而改变的部分。    
JDK中的Integer类的valueOf方法，内部的IntegerCache就是享元对象，默认-128~127会缓存，没有才new；而如果范围之外直接new。 

-  pattern.structural.flyweight   
1.IFlyWeight：定义享元对象接口类，工厂方法使用。   
2.FlyWeight：implements IFlyWeight，实现接口的享元类，区分好内部状态和外部状态。  
3.FlyWeightFactoryMethod：享元对象创建的工厂方法。  
(1)建立存放享元的容器池：如果不涉及线程安全可以使用HashMap；如果涉及线程安全得使用ConcurrentHashMap，同时内部方法得加锁。  
(2)享元模式关键：判断该对象在容器池中是否已有。如果该对象在容器池中已有，直接取出使用；如果该对象在容器池中没有，创建该对象并放入容器池。  
4.FlyWeightTest：
(1)testFlyWeight：调用方感受不到享元对象的创建过程，直接向工厂方法FlyWeightFactoryMethod.getFlyWeight(外部状态参数)创建享元对象。   
(2)testIntegerCacheFlyWeight：JDK中的Integer类的valueOf方法，内部的IntegerCache就是享元对象，默认-128~127会缓存，没有才new；而如果范围之外直接new。  
   
### 结构型：组合模式    
树形结构在软件中随处可见，例如操作系统中的目录结构、应用软件中的菜单、公司组织结构、商品和类目等。  
如何运用面向对象的方式来处理这种树形结构是组合模式需要解决的问题。  
组合模式通过一种巧妙的设计方案使得用户可以一致性地处理整个树形结构或者树形结构的一部分，
也可以一致性地处理树形结构中的叶子节点（不包含子节点的节点）和容器节点（包含子节点的节点）--继承统一父类或实现统一接口。
JDK中的容器类Collection中的例如ArrayList是一种Collection,可以add(任意一种Collection)。

-  pattern.structural.composite    
1.CatalogComponent：定义组合模式的顶层抽象构件类，是所有容器类和叶子类的公共父类。  
Leaf(叶子构件)和Composite(容器构件)都继承extends CatalogComponent，客户端作为调用方法只需要面向Component进行编程。  
2.ItemLeaf：extends CatalogComponent，商品Item是该组合模式的Leaf(叶子构件)。   
3.CatalogComposite：extends CatalogComponent，商品归属的类目Catalog是该组合模式的Composite(容器构件)，
其内部可以add父类CatalogComponent--这样可以add商品Itemleaf，也可以add类目CatalogComposite--组合模式的核心实现。  
4.CompositeTest：   
(1)定义商品ItemLeaf，定义类目CatalogComposite，将商品添加到类目容器中。   
(2)定义顶层(level=1)类目容器，将二级(level=2)类目容器添加到顶层类目容器中。  
(3)打印顶层类目容器，会将二级类目容器和底层商品遍历打印出来。    

### 结构型：桥接模式    
基于组合方式搭建桥梁，核心是在抽象类(抽象)中组合接口(实现)，将抽象和实现分离--抽象和实现都可以独立扩展。    
使用场景：一个类存在两个或多个独立变化的维度，且这两个或多个维度都有独立扩展的场景。    
使用组合而不是继承，符合合成复用原则。  
JDK中的DriverManager抽象类(抽象)中组合了Driver接口(实现)。   

-  pattern.structural.bridge   
1.IDeposit：存款接口，可以存定期和活期，后面可能会买理财等，有多种独立变化场景。   
2.CurrentDeposit和FixedDeposit：implements IDeposit，活期、定期存款定制实现类。   
3.Bank：银行抽象类。定义了桥接模式的核心：在抽象类(抽象)中组合IDeposit接口(实现)，让子类可以拿起来就用。   
4.ABCBank和ICBCBank：extends Bank，用于实例化具体的银行，抽象父类中组合了接口实现deposit的定义，继承子类可直接使用。  
5.BridgeTest：Bank类和各种存款IDeposit接口操作通过组合的方式，可以灵活独立扩展。   

### 结构型：代理模式    
为某对象提供代理，并对外控制对该对象的访问，代理起到中介作用，解耦分离被代理对象。  
使用场景：保护并增强被代理的对象。  
静态代理：组合要代理的对象，显式调用，保护和增强要代理的对象。     
动态代理：implements InvocationHandler，对接口实现类的动态代理，运行时动态代理类才被创建出来。在程序调用到代理类对象时，JVM根据传入的业务对象和方法名，
才开始真正创建代理类的class文件，被字节码引擎执行。JDK动态代理比CGlib性能高20%左右。     
每个被代理类都要显式的写个静态代理，而一个动态代理类可以代理多个被代理类。      
CGLib代理：针对类实现代理。继承为被代理类的子类，并重写其方法。要注意final类和final方法不能被继承和重写。底层使用ASM字节码，效率比反射高。     
Spring中，当Bean有实现接口时，Spring使用JDK的动态代理；当Bean没有实现接口时，Spring使用CGlib;
Spring也可以配置强制使用CGlib--<aop:aspectj-autoproxy proxy-target-class="true"/>   
MyBatis的mapper使用了JDK的原生动态代理模式，Spring中的AOP也使用了代理模式。   

-  pattern.structural.proxy   
在已有订单插入数据库的前提下，分别使用静态代理模式和动态代理模式，增强功能：按用户ID取模，动态选择数据库的数据源将订单插入。   
1.模拟原有订单插入数据库功能：   
1.l mode1.Order：model层的订单类Bean。    
1.2 dao.OrderDaoImpl：implements IOrderDao，模拟dao层的订单插入数据库操作。   
1.3 service.OrderServiceImpl：implements IOrderService，模拟service层的生成订单业务，调用dao层服务OrderDaoImpl使订单入库。  
1.4 db.DynamicDataSource：模拟动态选择数据库的数据源。    
2.staticproxy.OrderServiceStaticProxy：注入已有对象，静态代理显示增加beforeMethod和afterMethod方法，增强被代理对象OrderServiceImpl。   
3.dynamicproxy.OrderServiceDynamicProxy：implements InvocationHandler，动态代理模式，也是增强，与静态代理的不同是：
3.1通过Proxy的newProxyInstance方法在运行时创建动态代理对象。    
(1)第1个参数target.getClass().getClassLoader()，传入被代理对象的类加载器。    
(2)第2个参数target.getClass().getInterfaces()，传入代理需要实现的接口。   
(3)第3个参数handler，传入调用处理器。   
3.2重写invoke方法，参数Method是要被增强的方法对象，args是Method的参数。   
(1)动态代理增加beforeMethod方法，增强被代理对象，beforeMethod(args\[0]);   
(2)动态代理保护被代理对象Object object = method.invoke(target, args)      
4.ProxyTest：测试类验证静态代理和动态代理功能OK。   

## 行为型设计模式     
### 行为型：模板方法模式            
1.将不变的行为(方法)和流程(方法执行顺序)固化为模板方法(final类型)，子类继承时不可变。    
2.将可选固化行为，通过boolean标记，定义为钩子方法供继承子类或调用方自行决定是否使用父类提供的固化钩子方法。   
3.将可变的行为方法留给继承子类自行定制化实现。   
符合开闭原则，体现了控制反转的思想。JDK中的AbstrackList、httpServelet中的doGet、doPost、service方法使用了模板方法。   

-  pattern.behavioral.templatemethod    
1.TemplateMethod：定义了模板方法makeTemplate，内含final固化方法fixedMethod1和fixedMethod2、
可选固化钩子方法hookMethod、允许子类自行定制化实现的方法variableMethod。      
2.ChildClass1：继承子类直接定义是否使用父类TemplateMethod的钩子方法。   
3.ChildClass2：提供方法入参，转交给调用方决定是否使用父类TemplateMethod的钩子方法。   
4.TemplateMethodTest：测试上述模板方法OK。      

### 行为型：迭代器模式      
抽象出迭代器方法，顺序访问一个集合对象中的各个元素，而又不暴露该对象的内部表示。为遍历不同的集合结构提供一个统一的接口。   
JDK中的java.utils.Iterator接口，集合都实现了迭代器，还有MyBatis中的游标CursorIterator。  

-  pattern.behavioral.iterator   
1.Element：定义容器中的元素类。  
2.IteratorImpl implements IIterator：定义迭代器行为接口及其实现类。  
(1)IteratorImpl方法：有参构造方法，基于传入的List创建一个元素列表。  
(2)nextElement方法：获取当前元素的索引值position，并返回当前元素，索引值后移position++。  
(3)isLastElement方法：判断当前索引值position<列表长度size()，不是最后的元素，返回false；反之返回true。  
3.CollectionImpl implements ICollection：定义集合行为接口及其实现类。   
(1)CollectionImpl方法：无参构造方法，创建一个空的元素列表。  
(2)add方法：向集合中增加元素方法。  
(3)remove方法：向集合中删除元素方法。  
(4)getIterator方法：调用迭代器的有参构造方法IteratorImpl，构造一个迭代器。  
(5)iteratorPrintElement方法：this.getIterator()获取迭代器，基于迭代器iterator.isLastElement()方法，当不是最后一个元素时，
遍历集合元素iterator.nextElement()并打印出来。    
4.testIterator：构造一个集合，增加删除元素，测试验证迭代器遍历打印集合元素功能OK。      

### 行为型：策略模式     
策略模式定义了算法家族，分别封装起来(提高内部算法的保密性和安全性)，
让不同方法(流程)可互相替换，调用方可动态地在几种算法中选择一种使用。   
符合开闭原则，代码中有大量if else时候考虑使用。   
一般需结合工厂模式/单例模式/享元模式使用。   
JDK中的Comparator，要求各种策略都要实现其compare和equals方法。   

-  pattern.behavioral.strategy   
1.PromotionStrategy：定义商品促销策略行为接口。    
2.MoneyOffPromotionStrategy：implements PromotionStrategy，商品促销--满减策略。  
3.ReturnCashPromotionStrategy：implements PromotionStrategy，商品促销--返现策略。  
4.NoPromotionStrategy：implements PromotionStrategy，商品促销--不参加商品促销。
对应PromotionStrategyFactory中匹配不到促销策略的情况，避免空指针异常。  
5.PromotionStrategyFactory：核心功能，编写工厂方法，内部使用了策略模式封装不同的营销策略PromotionStrategy。
内部基于HashMap，key存储了if条件(哪种策略)，value存储了对应策略的实例化对象。      
6.PromotionCampaign：某次营销活动类，供调用方传入选择的策略，实现不同的商品促销行为。   
7.PromotionStrategyTest：对工厂方法+策略模式测试不同策略，OK。   

### 行为型：解释器模式    
给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器适用该表示来解释语言中的句子。
为了解释一种语言，而为语言创建解释器。   
适用场景：某个特定类型问题发生频率足够高。   
优点：语法由很多类表示，容易改变及扩展此“语言”。   
缺点：当语法规则数目太多时，增加了系统复杂度。   
JDK的util中的Pattern正则表达式模式匹配器是一种解释器。  

-  pattern.behavioral.interpreter    
自定义一个简单的自己实现的整数加法和乘法解释器。   
1.IInterpreter：定义解释器接口方法。   
2.AddInterpreter和MultiInterpreter：implements IInterpreter，实现加法操作符和乘法操作符的解释器具体实现类。   
3.NumberInterpreter：implements IInterpreter，实现用户输入数字字符转int的解释器具体实现类。   
4.OperatorUtil：判断加法或乘法操作，执行相应运算解释器的工具类。   
5.CustomizedExpressionParser：本解释器的核心类。   
(1)使用栈(先进后出)来存放用户每次输入的解释器。   
(2)用户输入字符串，约定空格作为分隔符，分隔为每个解释器需要解释的字符，存入StringList。   
(3)循环遍历该StringList。   
(4)如果字符不是加法或乘法符号，按约定用户输入的是数字，按约定用户输入的是数字，构造出对应的数字解释器，压入栈中。   
(5)否则，按约定用户输入的是加法或乘法运算符，把前面2个数字解释器先从栈里pop出来。     
(6)调用OperatorUtil执行相应的加法或乘法运算，计算出的阶段性结果，NumberInterpreter构造为解释器入栈。   
(7)用户输入字符遍历完成，输出最终结果(栈内唯一的值)。    
6.InterpreterTest：自定义的加法和乘法计算解释器测试验证OK。还测试了解释器SpelExpressionParser。   

### 行为型：观察者模式     
也叫发布-订阅模式，事件触发模式，定义了对象之间一对多依赖，让多个观察者对象同时监听某个主题对象。当主题对象发生变化时，它的所有观察者对象都会收到通知并更新。    
观察者与被观察者之间建立了一个抽象的耦合。关联行为场景，建立一套触发机制。支持广播通信(类似消息广播)。    
JDK中的EventListener接口就是事件触发模式。   
GuavaEvent作为被观察对象，EventBus.register(GuavaEvent)，EventBus.post(Object)，增加@Subscribe注解即可订阅。   

-  pattern.behavioral.observer   
1.BroadcastObject：定义一个类，作为消息发布-订阅的内容对象，也就是被观察对象的内容对象。  
2.Publish：extends Observable，消息的发布者，也就是被观察者。  
(1)setChanged()：订阅者关心的publishData发生改变时置变动标志位change为true。  
(2)notifyObservers(broadcastObject)：setChanged()时，调用父类Observable方法，通知所有观察者，notifyObservers可以参数携带通知内容对象。  
3.Subscribe：implements Observer，消息的订阅者，也就是观察者。   
(1)构造方法，将订阅者放入观察者Vector中。   
(2)update(Observable o, Object arg)：重写Observer的update方法，入参中的Observable o是被观察者对象， Object arg是被观察者notifyObservers的入参对象。   
4.ObserverTest：实例化一个Publish，2个Subscribe，Publish的数据变动时，通知2个Subscribe，数据更新但无变化时，不通知。   

### 行为型：备忘录模式     
保存一个对象的某个状态，以便在适当的时候恢复对象。使用实例来表示状态，存档是对象实例。     
核心实现：使用栈Stack后进先出存储快照，实现撤销或后退操作。     
spring-webflow工作流中的MessageMemento就使用了备忘录模式。   

-  pattern.behavioral.memento   
1.DocumentMemento：模拟每次用户存档的快照类，注意快照只允许构造生成，不允许set修改。    
2.Document：模拟一个文档类。   
(1)saveToMemento方法：用户点击保存文档，实际是对当前文档生成一个快照DocumentMemento。  
(2)undoMemento方法：用户点击撤销，实际是将前一次快照对象，赋值给文档对象。   
3.MementoManager：备忘者模式的核心，使用栈Stack后进先出push存储快照，pop实现撤销或后退操作。   
4.MementoTest：模拟编写文档Document，saveToMemento方法存档生成快照DocumentMemento，MementoManager入栈push存储，
用户点击撤销，MementoManager出栈pop快照DocumentMemento，赋值给文档对象Document。   

### 行为型：命令模式      
将“命令动作”这个功能方法进行抽象，封装成对象，以便适用不同的请求，用于封装命令组合变化的场景。   
解决了应用程序中对象的职责以及他们之间的通信方式，也就是对命令请求调用者(Invoker)和命令执行者(Receiver)的解耦，方便对命令(Command)进行各种控制。   
抽象出等待执行的行为。容易扩展新命令或下达一组命令。  
JDK中的Runnable是命令(Command)，我们多线程时会对其进行实现。  
适用场景：   
1. 命令的发送者和命令执行者有不同的生命周期。命令发送了并不是立即执行。   
2. 命令需要进行各种管理逻辑。   
3. 需要支持撤消/重做操作。   

-  pattern.behavioral.command    
1.Receiver：接收者角色，该角色就是干活的角色，Command命令的实际执行者。   
2.ICommand：将多种变化的命令抽象为接口，需要执行的所有命令都在这里声明，例如执行和撤销命令。注：撤销命令可以考虑备忘录模式。        
3.NoCommand：implements ICommand，在开始初始化时，对每个命令初始化成了NoCommand，也就是什么都不执行。避免空指针异常。   
4.ConcreteCommand1：implements ICommand，命令具体实现类，组合Receiver，支持批量执行和撤销动作B、A。  
5.ConcreteCommand2：implements ICommand，命令具体实现类，组合Receiver，支持批量执行和撤销动作C、A、B。   
6.Invoker：调用者角色，接收到命令，并执行命令，是命令模式中最重要的角色，这个角色用来对各个命令进行控制。   
7.CommandTest：实例化Receiver和Invoker，调用Invoker，分别传入ConcreteCommand1和ConcreteCommand2测试验证命令模式，OK。   

### 行为型：中介者模式    
定义一个 封装一组对象如何交互的对象。  
通过使对象明确的相互引用来解耦，并允许独立改变它们的交互，类间解耦。  
将一对多转化为一对一，降低程序复杂度。   
可以使用观察者模式实现中介者模式角色间通信。   
JDK中的util的timer就是中介者，使用sched方法和queue来协调定时任务TimerTask对象。  
适用场景：    
1.系统中，对象之间存在复杂的引用关系，产生的相互依赖关系结构混乱且难以理解时。  
2.交互的公共行为，如果需要改变时。  

-  pattern.behavioral.mediator   
1.User：需要交互的对象。   
2.Chat：中介者，定义封装一个User对象与多个User对象如何交互的对象。
3.MediatorTest：User通过中介者Chat来交互。   

### 行为型：责任链模式    
为请求创建一个接收此次请求对象的链。  
适用场景：一个请求的处理需要多个对象当中的一个或多个协作处理。    
优点：请求的发送者和接收者(请求的处理者)解耦；责任链可以动态组合。  
javax.servlet.Filter过滤器中的FilterChain，每个Filter就是责任链中的一个链条，chain.doFilter方法指定下一个责任链元素。   

-  pattern.behavioral.chainresponsibility   
1.Handler：处理者，定义了处理请求的接口。handler知道，下一个处理者handler是谁，如果自己无法处理请求，就转给下一个处理者handler。   
(1)定义属性下一级处理者nextHandler为protected，方便子类继承；  
(2)setNextHandler：责任链核心，为当前Handler设置下一级Handler。  
(3)requestHandle：定义抽象方法，对请求request的是自身处理还是交由下一级handler处理的判断逻辑让具体子类实现。   
2.ConcreteHandler1和ConcreteHandler2：Handler的具体实现类，实现requestHandle的哪些自己处理，哪些转交下一级handler处理的判断逻辑。
核心是this.nextHandler.requestHandle(request)。       
3.NotSupportHandler：Handler的具体实现类，所有Handler都处理不了时的最终处理Handler，在责任链最末端。  
4.ChainResponsibilityTest：客户端创建处理者的关联setNextHandler，形成责任链；创建多种请求，每个请求模拟为一个数字，不同大小，归属相应正确的责任链Handler处理。   

### 行为型：访问者模式    
一种将数据操作与数据结构(具有稳定通用操作方法)分离的设计模式。       
封装作用于某种数据类型(如List/Set/Map等)中各种元素的操作。可以在不改变各元素的类的前提下，定义作用于这些元素的操作。   
访问者模式的基本想法是：   
(1)软件系统中拥有一个由许多对象构成的、稳定通用操作的对象结构，让这些对象的类都拥有一个accept方法，该方法通常以一个抽象访问者作为参数，用来接受访问者对象的访问。    
(2)访问者是一个接口，它拥有一个visit方法，封装稳定操作，对访问到的对象结构中不同类型的元素做出不同的处理。   
(3)在对象结构的一次访问过程中，遍历整个对象结构，对每一个元素都实施 accept 方法，
在每一个元素的 accept 方法中会参数调用访问者的 visit 方法，从而使访问者得以处理对象结构的每一个元素，
可以针对对象结构设计不同的访问者类来完成不同的操作，达到区别对待的效果。   
增加访问者简单，但增加具有稳定通用操作方法的对象方法麻烦。   
JDK中nio.FileVisitor接口使用了访问者模式。   

-  pattern.behavioral.visitor    
1.IBill：一个比较稳定的对象结构，例如账单Bill稳定的只有收入Income和支出Expense两个功能。
核心是拥有一个accept方法，该方法以一个抽象访问者IVisitor作为入参，接受访问者对象的访问。    
2.ExpenseBill：implements IBill，IBill的具体支出实现类。内含支出项名称itemName、支出项金额expenseAmount、
支出项返现金额bonusAmount，重写实现accept方法，以抽象访问者为入参，接受访问者对自身的访问。    
3.IncomeBill：implements IBill，IBill的具体收入实现类。内含收入项名称itemName、收入项金额incomeAmount、
收入项交税金额taxAmount，重写实现accept方法，以抽象访问者为入参，接受访问者对自身的访问。    
4.IVisitor：定义访问者接口。访问者模式的前提，要访问对象的操作是稳定的，此时才能封装访问者。
要访问对象的操作稳定，例如账单Bill的每个访问者都有2种操作：查看支出账单、查看收入账单。   
5.TotalVisitor：implements IVisitor，访问者的具体实现类，模拟BOSS查看总的盈亏情况。  
重写IVisitor定义的查看支出账单、查看收入账单的2个visit方法，实现总盈亏指标的累加。   
定义getTotal方法，便于调用方获取总盈亏指标情况。   
6.ListVisitor：implements IVisitor，访问者的具体实现类，模拟财务查看每笔交易情况。  
重写IVisitor定义的查看支出账单、查看收入账单的2个visit方法，判断账单类型，罗列每笔支出和收入账单。  
7.BillList：定义一个账单IBill集合，支持增加IBill元素、使用访问者IVisitor遍历访问IBill元素。   
8.VisitorTest：
(1)构造支出和收入账单，add到BillList。   
(2)模拟BOSS使用TotalVisitor访问BillList，获取总盈亏指标。  
(3)模拟财务accountant使用ListVisitor访问BillList，获取每笔支出和收入账单。   

### 行为型：状态模式    
允许一个对象在其内部状态改变时，改变它的行为。  
将不同的状态隔离，每个状态一个类，让每一个状态对修改关闭，也就是封装状态类来改变状态，
外部只能通过向状态类使用context来改变状态，至于怎么改变，则完全隐藏起来。    
把各种状态的转换逻辑，分布到state的子类中，减少相互间依赖。  
适用场景：一个对象存在多个状态(不同状态下行为不同)，且状态可相互转换。   
优点是增加新的状态非常简单。   
缺点是状态多的业务场景导致类数目增加，系统变复杂。   
状态模式组成：   
环境上下文类(Context)：定义客户端调用接口。维护一个ConcreteState子类的实例，这个实例定义当前状态。   
抽象状态类(State)：定义一个接口，封装与Context的状态相关的各种行为。    
具体状态类(ConcreteState)：每一子类实现一个与Context的一个状态相关的行为。    

-  pattern.behavioral.state    
1.VideoContext：环境上下文类(Context)：定义客户端调用接口。维护一个VideoState实例，这个实例定义当前状态。  
setVideoState(VideoState videoState)方法：this.videoState.setVideoContext(this)是状态模式的核心。
将上下文VideoContext自身this，通过setVideoContext通知给各个状态videoState。         
2.VideoState：定义一个抽象状态类(State)，封装与Context的状态相关的各种行为。外部只能通过向状态类使用context来改变状态。    
3.PlayState/SpeedState/PauseState/StopState：extends VideoState的具体状态类(ConcreteState)，处于自身状态时，重写状态变化的方法。   
4.StateTest：实例化一个VideoContext，初始化VideoState为PlayState，通过VideoContext切换状态，验证状态变化OK。      




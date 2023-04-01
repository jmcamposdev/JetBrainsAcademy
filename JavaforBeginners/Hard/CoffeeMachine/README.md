# Coffee Machine
This project allows you to better understand the basic OOP, its main concepts such as classes, class methods and attributes, and get a taste of Java. Practice working with methods, challenge yourself with loops and conditions, and get more confident with OOP.

This Project is separate in **6 Stages** we will describe each stage.

## Stage 1 ✅
Let's start with a program that makes you a coffee – virtual coffee, of course. In this project, you will implement functionality that simulates a real coffee machine. It can run out of ingredients, such as milk or coffee beans, it can offer you various types of coffee, and, finally, it will take money for the prepared drink.

### Objectives 🎯
The first version of the program just makes you a coffee. It should print to the standard output what it is doing as it makes the drink.

### Solution 💡
For this Stage is so simple only I needed to do is to print the steps of the CoffeMachine like this:
``` java
System.out.println("Starting to make a coffee");
System.out.println("Grinding coffee beans");
System.out.println("Boiling water");
System.out.println("Mixing boiled water with crushed coffee beans");
System.out.println("Pouring coffee into the cup");
System.out.println("Pouring some milk into the cup");
System.out.println("Coffee is ready!");
``` 

## Stage 2 ✅
Now let's consider a case where you need a lot of coffee. Maybe you're hosting a party with a lot of guests! In these circumstances, it's better to make preparations in advance.

So, we will ask a user to enter the desired amount of coffee, in cups. Given this, you can adjust the program by calculating how much water, coffee, and milk are necessary to make the specified amount of coffee.

Of course, all this coffee is not needed  _right_  now, so at this stage, the coffee machine doesn't actually make any coffee.

### Objectives 🎯
Let's break the task into several steps:

1.  First, read the numbers of coffee drinks from the input.
2.  Figure out how much of each ingredient the machine will need. Note that one cup of coffee made on this coffee machine contains  _200 ml_  of water,  _50 ml_  of milk, and  _15 g_  of coffee beans.
3.  Output the required ingredient amounts back to the user.

### Solution 💡
For this Stage I have made the necessary calculations in the `System.out.println()` and the code would be:
``` java
Scanner sc = new Scanner(System.in);
System.out.println("Write how many cups of coffee you will need:");
int coffees = sc.nextInt();
System.out.println("For "+coffees+" cups of coffee you will need:");
System.out.println(200*coffees+" ml of water");
System.out.println(50*coffees+" ml of milk");
System.out.println(15*coffees+" g of coffee beans");
```

## Stage 3 ✅
A real coffee machine doesn't have an infinite supply of water, milk, or coffee beans. And if you input a really big number, it's almost certain that a real coffee machine wouldn't have the supplies needed to make all that coffee for you.

In this stage, you need to improve the previous program. Now you will check amounts of water, milk, and coffee beans available in your coffee machine at the moment.

### Objectives 🎯
Write a program that does the following:

1.  It requests the amounts of water, milk, and coffee beans available at the moment, and then asks for the number of cups a user needs.
2.  If the coffee machine has enough supplies to make the specified amount of coffee, the program should print  `"Yes, I can make that amount of coffee"`.
3.  If the coffee machine can make more than that, the program should output  `"Yes, I can make that amount of coffee (and even N more than that)"`, where  _N_  is the number of additional cups of coffee that the coffee machine can make.
4.  If the amount of given resources is not enough to make the specified amount of coffee, the program should output  `"No, I can make only N cup(s) of coffee"`.

Like in the previous stage, the coffee machine needs  _200 ml_  of water,  _50 ml_  of milk, and  _15 g_  of coffee beans to make one cup of coffee.

Example:
```
Write how many ml of water the coffee machine has:
> 300
Write how many ml of milk the coffee machine has:
> 65
Write how many grams of coffee beans the coffee machine has:
> 100
Write how many cups of coffee you will need:
> 1
Yes, I can make that amount of coffee
```

### Solution 💡
In this Stage I have validated all the inputs with a function called `getInt` which validates that the input is a number.

I get all the quantities from the machine and it calculates how many coffee it is capable of making to calculate that perform the `Math.min` in this way:
```
int machineCoffees = Math.min(Math.min(machineWater/200,machineMilk/50),machineBeans/15);
```

Then I ask the user how much coffee he needs. I calculate the requirements and I am ready to compare.

1. I compare is exactly what the machine is capable of doing if that is true I print: <br>` System.out.println("Yes, I can make that amount of coffee");`
2. If the amount of coffee in the machine is greater, I print:<br>`System.out.println("Yes, I can make that amount of coffee (and even "+(machineCoffees-numberOfCoffees)+" more than that)");`
3. If it is not possible to make the amount of coffee we print it:
`System.out.println("No, I can make only "+machineCoffees+" cup(s) of coffee");`

The code would look like this:
```java
if (machineCoffees == numberOfCoffees) {   	
	System.out.println("Yes, I can make that amount of coffee");
} else if (numberOfCoffees < machineCoffees) {   	
	System.out.println("Yes, I can make that amount of coffee (and even "+(machineCoffees-numberOfCoffees)+" more than that)");
} else {
	System.out.println("No, I can make only "+machineCoffees+" cup(s) of coffee");
}
```

## Stage 4 ✅
Let's simulate an actual coffee machine! What do we need for that? This coffee machine will have a limited supply of water, milk, coffee beans, and disposable cups. Also, it will calculate how much money it gets for selling coffee.

There are several options for the coffee machine we want you to implement: first, it should sell coffee. It can make different types of coffee: espresso, latte, and cappuccino. Of course, each variety requires a different amount of supplies, however, in any case, you will need only one disposable cup for a drink. Second, the coffee machine must get replenished by a special worker. Third, another special worker should be able to take out money from the coffee machine.

### Objectives 🎯
Write a program that offers to buy one cup of coffee or to fill the supplies or to take its money out. Note that the program is supposed to do one of the mentioned actions at a time. It should also calculate the amounts of remaining ingredients and how much money is left. Display the quantity of supplies before and after purchase.

1.  First, your program reads one option from the standard input, which can be  `"buy"`,  `"fill"`,  `"take"`. If a user wants to buy some coffee, the input is  `"buy"`. If a special worker thinks that it is time to fill out all the supplies for the coffee machine, the input line will be  `"fill"`. If another special worker decides that it is time to take out the money from the coffee machine, you'll get the input  `"take"`.
2.  If the user writes  `"buy"`  then they must choose one of three types of coffee that the coffee machine can make: espresso, latte, or cappuccino.
    -   For one espresso, the coffee machine needs  _250 ml_  of water and  _16 g_  of coffee beans. It costs  _$4_.
    -   For a latte, the coffee machine needs  _350 ml_  of water,  _75 ml_  of milk, and  _20 g_  of coffee beans. It costs  _$7_.
    -   And for a cappuccino, the coffee machine needs  _200 ml_  of water,  _100 ml_  of milk, and  _12 g_  of coffee beans. It costs  _$6_.
3.  If the user writes  `"fill"`, the program should ask them how much water, milk, coffee and how many disposable cups they want to add into the coffee machine.
4.  If the user writes  `"take"`  the program should give all the money that it earned from selling coffee.

At the moment, the coffee machine has  _$550_,  _400 ml_  of water,  _540 ml_  of milk,  _120 g_  of coffee beans, and  _9_  disposable cups.

To sum up, your program should print the coffee machine's state, process one query from the user, as well as print the coffee machine's state after that. Try to use functions for implementing every action that the coffee machine can do.


### Solution 💡
 The first step on this Stage is create a Enum for the Coffees and the enum is:
 ``` java
public enum CoffeeType {
	ESPRESSO (250, 0, 16,4),
    LATTE (350, 75, 20,7),
    CAPPUCCINO (200, 100, 12,6);
    
    private final int water;
    private final int milk;
    private final int beans;
    private final int price;
    
    CoffeeType(int water, int milk, int beans,int price) {
	    this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
	}
}
 ```

Now we ask the user to write an option to validate it with regex and implement each case.
1. `Buy` we ask him to enter the type of coffee he wants between 1 - 3 and we subtract the resources and add the price of the coffee.
The code would be:
```java
case "buy" -> {
	CoffeeType coffeeType = CoffeeType.CAPPUCCINO;
    int userType = getInt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:\n");
    switch (userType) {
	    case 1 -> coffeeType = CoffeeType.ESPRESSO;
        case 2 -> coffeeType = CoffeeType.LATTE;
        case 3 -> coffeeType = CoffeeType.CAPPUCCINO;
    }
    machineWater -= coffeeType.water;
    machineMilk -= coffeeType.milk;
    machineBeans -= coffeeType.beans;
    machineMoney += coffeeType.price;
    machineCups--;
}
```
2. `Fill` For this we ask you for all the data to enter what you want.
The code is:
```java
case "fill" -> {
	 machineWater += getInt("Write how many ml of water you want to add: \n");
     machineMilk += getInt("Write how many ml of milk you want to add: \n");
     machineBeans += getInt("Write how many grams of coffee beans you want to add: \n");
     machineCups += getInt("Write how many disposable cups you want to add: \n");
}
```
 3. `Take` is simple we print the money and reset the counter.
```java
case "take" -> {
	 System.out.println("I gave you $"+machineMoney+"\n");
     machineMoney = 0;
}
```

## Stage 5 ✅
Just one action is not so interesting, is it? Let's improve the program so it can do multiple actions, one after another. It should repeatedly ask a user what they want to do. If the user types  `"buy"`,  `"fill"`  or  `"take"`, then the program should do exactly the same thing it did in the previous step. However, if the user wants to switch off the coffee machine, they should type  `"exit"`. The program should terminate on this command. Also, when the user types  `"remaining"`, the program should output all the resources that the coffee machine has. This means that you shouldn't show the remaining stock levels at the beginning/end of the program.

Remember, that:

-   For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs  $4.
-   For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs  $7.
-   And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs  $6.

### Objectives 🎯
Write a program that will work endlessly to make coffee for all interested persons until the shutdown signal is given. Introduce two new options:  `"remaining"`  and  `"exit"`.

Do not forget that you can be out of resources for making coffee. If the coffee machine doesn't have enough resources to make coffee, the program should output a message that says it can't make a cup of coffee and state what is missing.

And the last improvement to the program at this step — if the user types  `"buy"`  to buy a cup of coffee and then changes his mind, they should be able to type  `"back"`  to return into the main cycle.

### Solution 💡
For this Stage I would start by implementing the `exit` functionality which is a `boolean` found in the `while` when you type `exit` in the `swich` you change the `boolean` to `true`.

Then it would touch to implement `remaining` for it I have created a function that prints all the information of the coffee pot.
The function is:
```java
public static String machineStatus(int water, int milk, int beans, int cups, int money) {
	 return "The coffee machine has:\n" +
                water+" ml of water" +
                milk+" ml of milk" +
                beans+" g of coffee beans" +
                cups+" disposable cups" +
                "$"+money+" of money."
    }
```

And finally validate at the time of purchase validate that the coffee machine has enough ingredients to make coffee for it and implemented `if` for each ingredient.
The code is:
```java
if (machineWater < coffeeType.water) {
	System.out.println("Sorry, not enough water!");
    break;
}
if (machineMilk < coffeeType.milk) {
    System.out.println("Sorry, not enough milk!");
    break;
}
if (machineBeans < coffeeType.beans) {
	System.out.println("Sorry, not enough beans!");
	break;
}
if (machineCups == 0) {
	System.out.println("Sorry, not enough cups!");
    break;
}
``` 

## Stage 6 ✅
Let's redesign our program and write a class that represents a coffee machine. The class should have a method that takes a string as input. Every time the user inputs a string to the console, the program invokes this method with one argument: the line that the user inputs to the console. This system simulates pretty accurately how real-world electronic devices work. External components (like buttons on the coffee machine or tapping on the screen) generate events that pass into the single interface of the program.

The class should not use system input at all; it will only handle the input that comes to it via this method and its string argument.

The first problem that comes to mind: how to write that method in a way that it represents all that coffee machine can do? If the user inputs a single number, how can the method determine what that number is: a variant of coffee chosen by the user or the number of the disposable cups that a special worker added into the coffee machine?

The right solution to this problem is to store the current state of the machine. The coffee machine has several states it can be in. For example, the state could be "choosing an action" or "choosing a type of coffee". Every time the user inputs something and a program passes that line to the method, the program determines how to interpret this line using the information about the current state. After processing this line, the state of the coffee machine can be changed or can stay the same.

Remember, that:

-   For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs  $4.
-   For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs  $7.
-   And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs  $6.

### Objectives 🎯
Your final task is to refactor the program. Make it so that you can communicate with the coffee machine through a single method.

### Solution 💡
For this Stage you can take a look at the published code as it is the final state with the `Machine` class, the `CoffeeType` enum and the `Main` part, the program works correctly with everything validated.

> **Thank you for reading the project and I hope you find it useful 😉 <br>
> If you liked it please give me ⭐️**


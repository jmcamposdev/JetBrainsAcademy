# Simple Chatty Bot
Get to know the basic syntax of Java and write a simple program using variables, conditions, loops, and methods.

Here, at the beginning of your programmer’s path, creating a simple console chat bot will do wonders to guide you through the basics of coding. During this journey, you will also play some word and number games that you are going to implement on your own. Pack up and let’s hit the road, my friend!

This Project is separate in **5 Stages** we will describe each stage.
## Result
<p align="center">
<img src="https://github.com/jmcamposdev/JetBrainsAcademy/blob/main/img/SimpleChattyBot/simpleChattyBot.gif?raw=true"/>
<p/>

## Stage 1 ✅
Digital personal assistants help people to drive cars, plan their day, buy something online. In a sense, they are simplified versions of artificial intelligence with whom you can talk.

In this project, you will develop step by step a simple bot that will help you study programming.

### Objectives 🎯
For the first stage, you will write a bot who displays a greeting, its name, and the date of its creation. First impressions count!

Your program should print the following lines:

```no-highlight
Hello! My name is {botName}.
I was created in {birthYear}.
```

Instead of  `{botName}`, print any name you choose and replace  `{birthYear}`  with the current year (four digits).

### Solution 💡
This is stage is so simple you need to use `System.out.println()` to print the two lines.

## Stage 2 ✅
The greeting part is great, but chatbots are also supposed to interact with a user. It's time to implement this functionality.

### Objectives 🎯
In this stage, you will introduce yourself to the bot so that it can greet you by your name.

Your program should print the following lines:
```no-highlight
Hello! My name is Aid.
I was created in 2020.
Please, remind me your name.
What a great name you have, {yourName}!
```
You may change the name and the creation year of your bot if you want.
Instead of  `{yourName}`, the bot must print your name entered from the standard input.

### Solution 💡
In this Stage we need to read the user Input, you can read the input with `Scanner` after read the `name` you needs to print the variable:
`System.out.println("What a great name you have, "+name+"!");`

## Stage 3 ✅
Keep improving your bot by developing new skills for it. We suggest a simple guessing game that will predict the age of a user.
It's based on a simple math trick. First, take a look at this formula:
```
age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
```
The numbers  `remainder3`,  `remainder5`, and  `remainder7`  are the remainders of the division of  `age`  by 3, 5, and 7 respectively.

It turns out that for each number ranging from  _0_  to  _104,_  the calculation will result in the number itself. This perfectly fits the ordinary age range, doesn't it? Ask the user for the remainders and use them to guess the age!

### Objectives 🎯
In this stage, you will introduce yourself to the bot. It will greet you by your name and then try to guess your age using arithmetic operations.
Your program should print the following lines:
```no-highlight
Hello! My name is Aid.
I was created in 2020.
Please, remind me your name.
What a great name you have, Max!
Let me guess your age.
Enter remainders of dividing your age by 3, 5 and 7.
Your age is {yourAge}; that's a good time to start programming!
```
Read three numbers from the standard input. Assume that all the numbers will be given on separate lines.

Instead of  `{yourAge}`, the bot will print the age determined according to the special formula discussed above.

### Solution 💡
In this Stage I implement the age using the algorithm from before and print the age

## Stage 4 ✅
Now you will teach your bot to count. It's going to become an expert in numbers!

### Objectives 🎯
In this stage, you will program the bot to count from 0 to any positive number users enter.
Example:
```no-highlight
Now I will prove to you that I can count to any number you want.
> 5
0!
1!
2!
3!
4!
5!
Completed, have a nice day!
```

### Solution 💡
For this stage we read the user's number and thanks to a `for` we print all the numbers with a `System.out.println(number + "!");`

## Stage 5 ✅
At the final stage, you will improve your simple bot so that it can give you a test and check your answers. The test should be a multiple-choice quiz about programming with any number of options. Your bot has to repeat the test until you answer correctly and congratulate you upon completion.

### Objectives
Your bot can ask anything you want, but there are two rules for your output:

-   the line with the test should end with the question mark character;
-   an option starts with a digit followed by the dot (`1.`,  `2.`,  `3.`,  `4.`)

If a user enters an incorrect answer, the bot may print a message:

```no-highlight
Please, try again.
```

The program should stop on the correct answer and print  `Congratulations, have a nice day!`  at the end.

Example:
```no-highlight
Why do we use methods?
1. To repeat a statement multiple times.
2. To decompose a program into several small subroutines.
3. To determine the execution time of a program.
4. To interrupt the execution of a program.
> 4
Please, try again.
> 2
Congratulations, have a nice day!
```

### Solution 💡
To implement the test I have printed the test with a Text Block used with `"""` and save the format in which it is placed.
Then with a `DoWhile` you read the user option and if it is not valid it is repeated until it is valid.

> **Thank you for reading the project and I hope you find it useful 😉 
> If you liked it please give me ⭐️**

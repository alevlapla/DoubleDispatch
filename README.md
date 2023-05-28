# Project Information ![GitHub last commit](https://img.shields.io/github/last-commit/alevlapla/DoubleDispatch)
The case study of implementing double dispatch based on the visitor design pattern. The desired final action must be dependent on dynamic types of two objects. The dynamic types are being processed in the environment of static typing.
Some detailed comments are presented in source code files.

# Case study
Given three types of the same interface: `RedCell`, `BlueCell`, `GreenCell`. Having taken two objects, it is required to process them either by default action or by special action.

|Object #1|Object #2|Handling action|
|:-:|:-:|:-:|
|`RedCell`|`RedCell`|special #1|
|`RedCell`|`BlueCell`|default|
|`RedCell`|`GreenCell`|default|
|`BlueCell`|`RedCell`|default|
|`BlueCell`|`BlueCell`|default|
|`BlueCell`|`GreenCell`|default|
|`GreenCell`|`RedCell`|default|
|`GreenCell`|`BlueCell`|special #2|
|`GreenCell`|`GreenCell`|default|

# Realizations
* branch [visitorbuilder](https://github.com/alevlapla/DoubleDispatch/tree/visitorbuilder): a builder builds a dispatcher object used for double dispatch.
* branch [selfvisitor](https://github.com/alevlapla/DoubleDispatch/tree/visitordumb): each object is an object to be visited and a visitor at the same time.
* branch [dumbvisitor](https://github.com/alevlapla/DoubleDispatch/tree/visitorself): two visitors called one after another.

# Theory source
* [Двойная диспетчеризация (Double dispatch)](https://habr.com/ru/articles/259031/), author [Johanan](https://habr.com/ru/users/Johanan/)

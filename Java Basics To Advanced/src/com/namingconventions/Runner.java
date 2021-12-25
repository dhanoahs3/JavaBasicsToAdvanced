package com.namingconventions;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.*;
public class Runner {
    /*packages - should be always lower case and should use it with internet domain name and then package name
    * like com.mypackage
    * if domain name contains a java keyword or contains a - or starts with a number start all of them with a _
    *  com.switch.mypackage ---- com._switch.mypackage
    * 1world.com  ------------->_1world.com
    * experts-exchange.com-------------->com.experts_exchange
    Class Names -first word is capital ,camelcase and are Nouns
    * LinkedLList
    * ArrayList
    * GearBox
    * Main
    * Runner
    * Interface names-capital ,camelcase
    * Comparable ,WebDriver
    * MethodNames-are often verbs .reflects what the function performs or the results it returns .
    * first letter is small.then camel case which is called mixed case
    * getName()
    * size
    * addPlayerToList
    * Constats-All UPPERCASE,Words seperated by _ and always use final keyword
    * examples -  static final MAX_INT ,static final short SEVERITY_ERROR
    * static final double P1 = 3.14159
    * Variable names -
    * mixedCase   - first letter small and first letter of other words capital
    * variable name should be meaningful abd indicative .DONT use underscores.
    * Examples !
    * i , league sydneySwan ,boxLength
    *
    * Type parameters
    * E - Element(used extensively  by Java collections framework)
    * K - Key
    * T -Type
    * V - Value
    * S,U,V etc 2nd ,3rd ,4th type.
    *
    * packages are used to group similar classes together.
    * importing packages in java --->
    * We can either import a package in java and then  the classes from that package later on like this
    * import javafx.scene.Node
    * Node node = null;
    * or we can simply use the Node Class without importing the package just like this
    * javafx.scene.Node = null;
    * Please note if we have two different nodes in that we are using in our package we can't just import both of
    * them .We have to use atleast one of them the way we are using here
    * org.wj3.done.Node nodeTwo = null;
    * Also note we can either import single classes from a package like this import java.awt.Frame;
    * Or simply import all the classes of a particular package like this import java.awt.*
    * Also note that import java.awt.event.* is a seperate package all together so java.awt.* wont import it and have
    * to import it separately.
    * Also note we can go external libraries on the left hand side in intellij and see all available packages there.
    * or we can click on any classes in the imports like click on Frame in import java.awt.Frame and then see what the
    * Frame class does.
     *benefits of packages
     * Similar classes and packages are grouped together.
     * class and interface name conflicts are avoided . as classes have names based on packages like we can have
     * same name for class in two different packages but will not lead to any conflict
     * com.mypackage1.MyClass1
     * com.mypackage2.MyClass1
     * classes in the package have full access to each other but package can restrict access outside a pacakge

     /
     */
}

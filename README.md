# Java Socket Program (Calculator)

Purpose of this program:
------------------------
To show a client server communication in java.

How to run this program on a Single Computer:
---------------------------------------------
This program MUST run in two separate DOS windows.
One for Client(Client.java) and other for Server(Server.java).

-> Extract the Calculator.zip file to a folder in the disk.
-> Open DOS window and change directory to that folder using "cd" command.
-> Issue the command "java Server"
-> Open another DOS window and change the directory to that folder.
-> Issue the command "java Client"
-> Only the username is necessary. You can leave other options blank
      by only pressing enter key at them.
-> A menu will now be in front of you. Use the options to play with it.

How to run this program over a LAN or Internet:
-----------------------------------------------
-> First of all you need to run Server.java on any computer that is
      connected to the internet or a LAN using "java Server" command.
-> Then, run the Client.java on any other computer that is connected
      to the internet or to the LAN. The command is "java Client.java".
-> When you run the client, You MUST GIVE THE IP OF THE SERVER ON WHICH
      "Server.java" IS RUNNING.
-> Leave the Port number blank by pressing enter key.
-> After you give your username, it should connect to the server and
      give you a menu to choose options from.
-> Any number of clients can connect to the server at the same time,
      because the server is multithreaded.

How to get the IP of the server
--------------------------------
-> Open the DOS window on the computer on which Server.java is running.
-> In Win9x/WinMe go to the directory C:\Windows.
-> In WinNT/Win2000 go to the directory C:\WINNT
-> Issue the command "ipconfig"

How to compile the program:
---------------------------
I compiled this program using jdk1.4.1.
The .class files are the compiled files. If anything goes wrong
   using the command (java Client OR java Server), try compiling
   using your own JDK.
To compile Client: javac Client.java
To compile Server: javac Server.java

Requirements:
-------------
-> (Java2 Runtime Environment 1.2 or above) OR (Java2 SDK 1.2 or above)
-> Any operating system that has the Java2 installed in it.


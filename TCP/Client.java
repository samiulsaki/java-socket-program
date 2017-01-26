import java.io.*;
import java.net.*;
import java.util.Hashtable;

public class Client
{

	public static void main(String []args)
	{
		// Declarations to get input from keyboard
		// ---------------------------------------
		int port=555;			// server port
		String strPort="",		// server port
			   ip="",			// IP of server
			   strUserName="";	// User name of client

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		// Get ip, port & user name from the client
		try
		{
			// instructions
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("Instructions to connect to the Server.\n\n" +
				"## If the server is running on the same computer, " +
				"just press enter key or enter \"127.0.0.1\".\n\n" +
				"## Do not enter anything when it asks for port unless " +
				"you didn't edit the code in Server.java.\n" +
				"(Just leave it blank by pressing the enter key)\n\n" +
				"## Enter the UserName of your choice.\n(It can be you own name).\n");

			// get IP from the user
			System.out.print("\n\nEnter IP of the server (or press return): ");
			ip = input.readLine();
			if (ip.equals(""))
				ip = "127.0.0.1";	// default IP

			// get port from user
			System.out.print("Port Number (or press return): ");
			strPort = input.readLine();
			if (strPort.equals(""))
				port = 555;			// default port
			else
				port = Integer.parseInt(strPort);

			// get user name from the client
			strUserName = "temp";
			do
			{
				System.out.print("Enter User Name (mandatory): ");
				strUserName = input.readLine();
			}
			while (strUserName.equals(""));	// repeat until valid user name is given


			// --------------------------------------------------------------
			// IP, port and username is complete at this point
			// Now, create a socket to connect to server.
			// After that manage the connection in a while loop
			// until user wants to exit on his/her will
			// --------------------------------------------------------------

			// create a new socket
			Socket socket = new Socket(ip, port);

			// Connection successfull at this point, so inform user about this
			System.out.print("\n\n\t\tConnection successful.\n\t\t----------------------");

			// Declarations to manage connection
			// ---------------------------------
			String strAnother = "z",	// looping variable
				   strInt1 = "10",		// First integer
				   strInt2 = "10",		// Second integer
				   strOp = "-",			// Operator
				   strResult="";
			// to get data to and from server
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			OutputStream out = socket.getOutputStream();
			PrintWriter pr = new PrintWriter(out, true);

			// send user name to the server
			pr.println(strUserName);

			// The while loop
			// --------------
			while (strAnother.charAt(0) != 'd')
			{
				// giver user a menu
				System.out.println("\n\nEnter (d) to disconnect from server.\n" +
					"      (s) to see other online people.\n" +
					"      (z) or any other key to solve a simple expression.  ");
				strAnother = input.readLine();
				if (strAnother.equals(""))
					strAnother = "z";
				switch(strAnother.charAt(0))
				{
					case 'd':
						pr.println("d");
						break;
					case 's':	// send notification to server to see online people
						pr.println("s");	// write (s) to server
						strResult = br.readLine();
						System.out.println(strResult);
						break;
					default:	// send expression to the server
						pr.println("z");
						// get first number
						System.out.print("Enter First Number: ");
						strInt1 = input.readLine();
						if (strInt1.equals(""))
							strInt1 = "10";

						// get second number
						System.out.print("Enter Second Number: ");
						strInt2 = input.readLine();
						if (strInt2.equals(""))
							strInt2 = "10";

						// get operator
						System.out.print("Enter Operator: ");
						strOp = input.readLine();
						if (strOp.equals(""))
							strOp = "-";

						// write 2 integers and operator to the server
						pr.println(strInt1);
						pr.println(strInt2);
						pr.println(strOp);

						// get result from the server
						strResult = br.readLine();
						System.out.println(strResult);
						break;
				}	// End of switch
			}	// End of the while loop

			// At this point client wants to disconnect from the server,
			// so close the connection
			socket.close();

		}	// End of try
		catch(Exception e)
		{
			System.out.println("Some kind of error has occurred.");
			System.exit(0);
		}	// End of exception

	}	// End of main()
}	// End of class

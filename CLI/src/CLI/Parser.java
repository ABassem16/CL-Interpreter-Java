package CLI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Parser
{
	ArrayList<String> args=new ArrayList<>();
	String[] funcs= {"cp","date","exit","help","cd","mkdir","rmdir","ls","clear","mv","cat","mv","more","pwd","rm"};
	String cmd;
	public boolean parse(String input)
	{
		String check[]=input.split(" ");
		{
			if(check.length>3 || check.length<1)
			{
				return false;
			}
		}
		for(int i=0;i<funcs.length;i++)
		{
			if(check[0].contains(funcs[i]))
			{
				cmd=check[0];
				if(check.length>1)
				{
				for(int j=1;j<check.length;j++)
				{
					args.add(check[j]);
				}
				}
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			Parser pars=new Parser();
			Terminal term=new Terminal();
			String command=scan.nextLine();
			if(pars.parse(command)==true)
			{
				if(pars.cmd.contentEquals("cp"))
				{
					if(pars.args.size()==1)
					{
						term.cp(pars.args.get(0));
					}
					else if(pars.args.size()==2)
					{
						term.cp(pars.args.get(0),pars.args.get(1));
					}
					else
					{
						System.out.println("cp takes only one/two arguments");
					}
				}
				if(pars.cmd.contentEquals("mkdir"))
				{
					if(pars.args.size()==1)
					{
					term.mkdir(pars.args.get(0));
					}
					else
					{
						System.out.println("mkdir takes exactly one argument.");
					}
				}
				if(pars.cmd.contentEquals("rmdir"))
				{
					if(pars.args.size()==1)
					{
					term.rmdir(pars.args.get(0));
					}
					else
					{
						System.out.println("rmdir takes exactly one argument.");
					}
				}
				if(pars.cmd.contentEquals("ls"))
				{
					if(pars.args.size()==1)
					{
					term.ls(pars.args.get(0));
					}
					else
					{
						System.out.println("ls takes only one argument.");
					}
				}
				if(pars.cmd.contentEquals("clear"))
				{
					if(pars.args.size()==0)
					{
					term.clear();
					}
					else
					{
						System.out.println("clear doesn't take arguments.");
					}
				}
				if(pars.cmd.contentEquals("cd"))
				{	
					if(pars.args.size()==1)
					{
					term.cd(pars.args.get(0));
					}
					else
					{
						System.out.println("cd takes only one argument.");
						
					}
				}
				if(pars.cmd.contentEquals("more"))
				{
					if(pars.args.size()==1)
					{
					term.more(pars.args.get(0));
					}
					else
					{
						System.out.println("more takes only one argument");
					}
				}
				if(pars.cmd.contentEquals("mv"))
				{
					if(pars.args.size()==2)
					{
					term.mv(pars.args.get(0),pars.args.get(1));
					}
					else
					{
						System.out.println("mv takes two arguments.");
						
					}
				}
				if(pars.cmd.contentEquals("cat"))
				{
					if(pars.args.size()==1)
					{
					term.cat(pars.args.get(0));
					}
					else if(pars.args.size()==2)
					{
						term.cat(pars.args.get(0),pars.args.get(1));
					}
					else
					{
						System.out.println("cat takes only one/two arguments.");
						
					}
				}
				if(pars.cmd.contentEquals("pwd"))
				{
					if(pars.args.size()==0)
					{
					term.pwd();
					}
					else
					{
						System.out.println("pwd doesn't take arguments");
					
					}
				}
				if(pars.cmd.contentEquals("rm"))
				{
					if(pars.args.size()==1)
					{
					term.rm(pars.args.get(0));
					}
					else
					{
						System.out.println("rm takes only one argument.");
					
					}
				}
				if(pars.cmd.contentEquals("exit"))
				{
					System.out.println("Good bye");
					System.exit(0);
				}
				if(pars.cmd.contentEquals("date"))
				{	
					Date date=new Date();
					System.out.println(date.toString());
				}
				if(pars.cmd.contentEquals("help"))
				{
					System.out.println("args : \ncp(String sp,String dp)\nmv(String sp,String dp) \nmkdir(String dir)\nrmdir(String dir)\ncat(String sp,String dp)\ncat(String sp)\nmore()\nclear()\nls(String list)\ncd(String dp)\npwd()\nrm(String sp)\ndate : Current date/time\nexit : Stop All");
				}
			}
			else
			{
				System.out.println("Command not Recognized");
				break;
			}
		}
		scan.close();
	}
}

package CLI;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
public class Terminal
{
	public void cp(String sp,String dp)
	{
		try
		{
		File fsp=new File(sp);
		File dsp=new File(dp);
		if(fsp.exists() && dsp.exists() && fsp.isFile() && dsp.isFile())
		{
			Files.move(fsp.toPath(),dsp.toPath());
			System.out.println("File Copied Successfully");
		}
		else
		{
			System.out.println("One of The Files Doesn't exist or is a directory.");
		}
		}
		catch(IOException i)
		{
			System.out.println("Input/Output Error");
		}
		
	}
	public void cp(String sp)
	{
		try
		{
		File fsp=new File(sp);
		
		if(fsp.exists() && !fsp.isDirectory())
		{
		 File newf=new File("Copy.txt");
		 newf.createNewFile();
		 Files.move(fsp.toPath(),newf.toPath());
		 System.out.println("File Copied Successfully");
		}
		else
		{
			System.out.println("File Doesn't Exist or is a Directory");
		}
		}
		catch(IOException i)
		{
			System.out.println("Input/Output Error");
		}
	}
	public void mkdir(String dir)
	{
		File mkd=new File(dir);
		if(mkd.exists() && mkd.isDirectory())
		{
			System.out.println("This Directory Already Exists.");
		}
		else
		{
			mkd.mkdir();
			if(mkd.mkdir())
			{
				System.out.println("Directory Created Successfully");
			}
			
		}
	}
	public void rmdir(String dir)
	{
		File rmdir=new File(dir);
		if(rmdir.exists())
		{
			rmdir.delete();
		}
		else
		{
			System.out.println("Directory Doesn't Exist.");
		}
	}
	public void ls(String dir)
	{
		File ls=new File(dir);
		String[] files=ls.list();
		for(int i=0;i<files.length;i++)
		{
		System.out.print(files[i] + " / ");
		}
			
	}
	public void clear()
	{
		for(int i=0;i<50;i++)
		{
		System.out.println();
		}
	}
	public void cd(String dir)
	{
		File cd=new File(dir);
		if(cd.isDirectory())
		{
			System.setProperty("user.dir",cd.getAbsolutePath());
		}
		else
		{
			System.out.println("This isn't a Directory.");
		}
	}
	public void mv(String sp,String dp)
	{
		try
		{
		File fsp=new File(sp);
		File dsp=new File(dp);
		if(fsp.exists() && dsp.exists())
		{
			Files.move(fsp.toPath(),dsp.toPath());
			System.out.println("Files Moved Successfully");
		}
		else
		{
			System.out.println("One of the Files doesn't Exist.");
		}
		}
		catch(IOException x)
		{
			System.out.println("Input/Output Error");
		}
	}
	public void cat(String sp,String dp)
	{
		try
		{
		FileReader fsp=new FileReader(sp);
		FileReader fdp=new FileReader(dp);
		BufferedReader buff=new BufferedReader(fsp);
		BufferedReader buff2=new BufferedReader(fdp);
		String s="";
		String all="";
		while((s=buff2.readLine())!=null)
		{
			all+=s;
		}
		buff2.close();
		s="";
		while((s=buff.readLine())!=null)
		{
			all+=s;
		}
		System.out.println(all);
		buff.close();
		}
		catch(FileNotFoundException f)
		{
			System.out.println("File Not Found");
		}
		catch(IOException i)
		{
			System.out.println("Input/Output Error");
		}
	}
	public void cat(String sp)
	{
		try
		{
		FileReader fsp=new FileReader(sp);
		BufferedReader buff=new BufferedReader(fsp);
		String s="";
		while((s=buff.readLine())!=null)
		{
			System.out.println(s);
		}
		buff.close();
		}
		catch(FileNotFoundException f)
		{
			System.out.println("File Not Found");
		}
		catch(IOException i)
		{
			System.out.println("Input/Output Error");
		}
		
	}
	public void more(String file)
	{
		try
		{
		FileReader fsp=new FileReader(file);
		BufferedReader buff=new BufferedReader(fsp);
		String s="";
		while((s=buff.readLine())!=null)
		{
			String ss[]=s.split(" ");
			for(int i=0;i<ss.length;i++)
			System.out.println(ss[i]);
		}
		buff.close();
		}
		catch(FileNotFoundException f)
		{
			System.out.println("File Not Found");
		}
		catch(IOException i)
		{
			System.out.println("Input/Output Error");
		}
	}
	public void pwd()
	{
		String pwd=System.getProperty("user.dir");
		System.out.println(pwd);
	}
	public void rm(String sp)
	{
		File fsp = new File(sp);
		if(fsp.exists() && !fsp.isDirectory())
		{
			fsp.delete();
			System.out.println("File Deleted Successfully");
		}
		else
		{
			System.out.println("File Doesn't Exist or is a Directory.");
		}
	}
}

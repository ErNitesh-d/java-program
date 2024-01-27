import java.sql.*; 
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;


	
		class add_update extends JFrame implements ActionListener{
			private static final long serialVersionUID = 1L;

		JLabel lname;
		JLabel lage;
		JLabel l,lid;
		JTextField txtid, txtname, txtage;
		Connection con;
		Statement stmt, st;
		ResultSet rs;
		JButton cmdadd, cmdupdate, cmddelete, cmdfirst, cmdnext, cmdprevious, cmdlast,cmdexit;


		
		
		add_update(String s) {
		Container c=getContentPane();

		lid=new JLabel("Id");
		lid.setBounds(10,5,180,30);
		c.add(lid);
		txtid=new JTextField(10);
		txtid.setBounds(98,5,180,30);
          c.add(txtid);

		lname= new JLabel("Name");
		lname.setBounds (10,40,180,30);
		c.add(lname);
		txtname=new JTextField(10);
	  txtname.setBounds(90,40,180,30);
		c.add(txtname);
	

		lage=new JLabel ("Age");
		lage.setBounds (10,90,180,30);
		c.add(lage);
		txtage =new JTextField(10);
		txtage.setBounds (90, 90, 180,30);
		c.add(txtage);

		cmdadd= new JButton("Add");
		cmdadd.setBounds(20,148,78,30);
		c.add(cmdadd);
		
		cmdupdate= new JButton("Update");
		cmdupdate.setBounds (100, 140,98,30);
		c.add(cmdupdate);
		
		cmddelete =new JButton("Delete");
		cmddelete.setBounds (200, 140,70,30);
		c.add(cmddelete);

		cmdfirst =new JButton("First");
		cmdfirst.setBounds (280,140, 70,30);
		c.add(cmdfirst);

		cmdnext= new JButton("Next");
		cmdnext.setBounds (360,140, 78,30);
		c.add(cmdnext);

		cmdprevious= new JButton("Previous");
		cmdprevious.setBounds(440, 140,90,30);
		c.add(cmdprevious);

		cmdlast =new JButton("Last");
		cmdlast.setBounds (540,140, 70,30);
		c.add(cmdlast);

		
		cmdexit = new JButton("Exit");
		cmdexit.setBounds (300, 200, 70,30);
		c.add(cmdexit);

		l=new JLabel("");
		l.setBounds(10,20,70,40);
		c.add(l);

		cmdadd.addActionListener(this); 
		cmdupdate.addActionListener(this);
		cmddelete.addActionListener(this);
		cmdfirst.addActionListener(this);
		cmdnext.addActionListener(this);
		cmdprevious.addActionListener(this);
		cmdlast.addActionListener(this);
		cmdexit.addActionListener(this);

		setSize(300, 300);

		try{

		Class.forName("com.mysql.cj.jdbc.Driver");

		con=DriverManager.getConnection("jdbc:mysql://localhost/collage","root","");
		stmt=con.createStatement();

		st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
				rs =st.executeQuery("select * from student"); 

		rs.next();

		txtid.setText(rs.getString(1));
		txtname.setText(rs.getString(2));
		txtage.setText(rs.getString(3));

		}catch(ClassNotFoundException e) {l.setText(e.getMessage());}
			catch (SQLException se)
		{ 
				System.out.print(se);
		}

	}
		
		
		
		public void actionPerformed (ActionEvent ae) {
			if(ae.getSource() ==cmdadd)
			{
	        	try{
	        		
		               String id=txtid.getText().toString();
		               String name=txtname.getText().toString();
                  		String age=txtage.getText().toString();
                         con.createStatement();
	     	           String s="insert into student values('"+id+"','"+name+"', '"+age+"')";
	     	         	stmt.executeUpdate(s);
	     	 	     l.setText("record inserted..");
	        	}
		          catch (SQLException se){
		        	  System.out.print(se); }

		catch (Exception se) 
	        	{
			System.out.print(se); }
			}

		if(ae.getSource() ==cmdupdate)
		{
		try
		{
		String id=txtid.getText().toString();

		String name=txtname.getText().toString();
		String age=txtage.getText().toString();

		con.createStatement(); 
		
		
		String s="update student SET name='"+name+"',age='" +age+"' where id='"+id+"'";

		stmt.executeUpdate(s);

		l.setText( "record updated�");

		}
	     catch (SQLException se){ System.out.print(se); }
		catch (Exception se){ System.out.print(se); }
		}
		if(ae.getSource() ==cmddelete)
		{
      try {

		String id=txtid.getText().toString();

		con.createStatement();

		String s="delete from student where id='"+(id)+"'";

		stmt.executeUpdate(s);

		l.setText( "record deleted�"); 
		} catch(SQLException se){

		        System.out.print(se); } 
		catch (Exception se) { System.out.print(se); }
		}
		if(ae.getSource() ==cmdfirst)
		{
		try{

		rs.first();

		txtid.setText(rs.getString(1));

		txtname.setText(rs.getString(2)); txtage.setText(rs.getString(3));

		}catch(Exception e) { System.out.print(e);}
		}
		
		if(ae.getSource() ==cmdnext)
		{
		try{

		rs.next();

		txtid.setText(rs.getString(1)); txtname.setText(rs.getString(2)); txtage.setText(rs.getString(3));

		}catch(Exception e){ System.out.print(e);}
		}
		if(ae.getSource()== cmdprevious)
        {
		 try{

		rs.previous();

		txtid.setText(rs.getString(1)); txtname.setText(rs.getString(2));

		txtage.setText(rs.getString(3));

		}catch(Exception e) { System.out.print(e); }
        }
		if (ae.getSource() ==cmdlast)
		{
		try {

		rs.last(); txtid.setText(rs.getString(1));

		txtname.setText(rs.getString(2));
		txtage.setText(rs.getString(3));
		  }
		 catch (Exception e) { System.out.print(e);}
		
		}
		if(ae.getSource() ==cmdexit)
		{
		System.exit(0);

		}
    }
}
		
	
		public class dataform
		{
			
		public  static  void main(String args[]) {
			
		

		add_update f = new add_update("Add Update Form");

		f.setSize(700,400); f.setVisible(true);
	

	}
		}



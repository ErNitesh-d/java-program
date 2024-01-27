class varargsex
{
   static void display(int...values)
   {
     System.out.println("display the varargs value");
	 for(int i:values)
	 System.out.println(i+"  ");
	 System.out.println();
	}
public static void main(String args[])
{
  display();
display(12,21,123,123,12);
  display(13);
  display(60,70,80);
  }
}

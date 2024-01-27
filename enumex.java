class enumex
{
   public enum direction{SUNDAY,MONDAY,TUESHDAY,WEDNESDAY,THURSHDAY,FRIDAY,SATURDAY}
   public static void main(String args[])
   {
     for(direction d:direction.values())
	 System.out.println(d);
   }
}                    
import java.util.*;
public class diceSort
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    Random rn = new Random(); int sides = sc.nextInt();
    int dice[] = new int [5]; int freq[] = new int [6];
    int count = 0; int bigFreq = 0;
    long millisStart = Calendar.getInstance().getTimeInMillis();
    for(int i = 0; i<5; i++) //random array
    {
      dice[i] = rn.nextInt(sides)+1;
    }
    for(int i = 1; i<6; i++)  //create a frequency table of outcomes and find the most freqent value
    {
      for(int j = 0; j<5;j++)
      {
        if(i == dice[j])
          freq[i]++;
      }
      if(freq[i]>bigFreq)
        bigFreq = i;
    }
    for(int i = 0; i<5; i++)
    {
      if(dice[i] != bigFreq) //dice value doesnt equal to the most frequent value therefore reroll
      {
        dice[i] = rn.nextInt(sides)+1;
        i--; count++;
      }
    }
    long millisFinish = Calendar.getInstance().getTimeInMillis();
    System.out.println("Yahtzee after " +  count  + " rolls" + "\n" + (millisFinish - millisStart) + "ms to run.");
  }
}

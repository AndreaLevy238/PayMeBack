public class Date {
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public void printShortDate() {
        String date = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
        System.out.println(date);
    }

    private boolean validMonth()
    {
        return month > 0 && month < 13;
    }

    private boolean validDay()
    {
        boolean answer = false;
        if(validMonth())
      {
          switch(month)
          {
              case 1:case 3:case 7:case 8:case 10:case 12:
                answer = day <= 31;
                break;
              case 4:case 6:case 9:case 11:
                answer = day <= 30;
                break;
              case 2:
                  if (year % 4 == 0)
                  {
                      answer = day <= 29;
                  }
                  else
                  {
                      answer = day <= 28;
                  }
                  break;
          }
      }
        return answer;
    }
    private boolean validYear()
    {
        return year > 1900 && year < 2100;
    }
    public boolean isVslid()
    {
        return validMonth() && validDay() && validYear();
    }

}

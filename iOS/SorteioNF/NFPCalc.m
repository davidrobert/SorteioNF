#import <stdio.h>
#import <time.h>
#import "NFPCalc.h"

@implementation NFPCalc: NSObject

- (long)calculateForTodayWithIndividualValue: (double) individualValue andNumberOfPeople: (int) numberOfPeople
{
  time_t result = time(NULL);
  struct tm *currentTime = localtime(&result);

  int dayOfMonth = currentTime->tm_mday;

  long value = [self calculateForDay: dayOfMonth andIndividualValue: individualValue andNumberOfPeople: numberOfPeople];

  return value;
}

- (long)calculateForDay: (int) dayOfMonth andIndividualValue: (double) individualValue andNumberOfPeople: (int) numberOfPeople
{
  int relevantPart = (int) (individualValue * 100);

  int intPart = relevantPart / 100;
  int centsPart = relevantPart % 100;

  return (intPart + centsPart + dayOfMonth) % numberOfPeople;
}

@end

void runTests(void)
{
  NFPCalc *myNfpCalc = [NFPCalc new];

  long value = [myNfpCalc calculateForDay: 13 andIndividualValue: 19.44 andNumberOfPeople: 4];
  if (value != 0) {
    printf("error 1, value = %ld\n", value);
    return;
  }

  value = [myNfpCalc calculateForDay: 13 andIndividualValue: 19.45 andNumberOfPeople: 4];
  if (value != 1) {
    printf("error 2, value = %ld\n", value);
    return;
  }
  
  value = [myNfpCalc calculateForDay: 13 andIndividualValue: 19.46 andNumberOfPeople: 4];
  if (value != 2) {
    printf("error 3, value = %ld\n", value);
    return;
  }
  
  value = [myNfpCalc calculateForDay: 13 andIndividualValue: 19.47 andNumberOfPeople: 4];
  if (value != 3) {
    printf("error 4, value = %ld\n", value);
    return;
  }
  
  value = [myNfpCalc calculateForDay: 13 andIndividualValue: 19.48 andNumberOfPeople: 4];
  if (value != 0) {
    printf("error 5, value = %ld\n", value);
    return;
  }
  

  value = [myNfpCalc calculateForDay: 19 andIndividualValue: 15.20 andNumberOfPeople: 3];
  if (value != 0) {
    printf("error 6, value = %ld\n", value);
    return;
  }
  
  value = [myNfpCalc calculateForDay: 19 andIndividualValue: 15.21 andNumberOfPeople: 3];
  if (value != 1) {
    printf("error 7, value = %ld\n", value);
    return;
  }
  
  value = [myNfpCalc calculateForDay: 19 andIndividualValue: 15.22 andNumberOfPeople: 3];
  if (value != 2) {
    printf("error 8, value = %ld\n", value);
    return;
  }
  
  value = [myNfpCalc calculateForDay: 19 andIndividualValue: 15.23 andNumberOfPeople: 3];
  if (value != 0) {
    printf("error 9, value = %ld\n", value);
    return;
  }

  printf("all tests Ok!\n");
}

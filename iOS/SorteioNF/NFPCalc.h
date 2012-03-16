@interface NFPCalc: NSObject
{
}

- (long)calculateForTodayWithIndividualValue: (double) individualValue andNumberOfPeople: (int) numberOfPeople;
- (long)calculateForDay: (int) dayOfMonth andIndividualValue: (double) individualValue andNumberOfPeople: (int) n;
void runTests(void);

@end

//
//  ViewController.m
//  SorteioNF
//
//  Created by ios2534 on 13/03/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import "ViewController.h"
#import "NFPCalc.h"

@implementation ViewController
@synthesize totalIndividual;
@synthesize numeroDePessoas;

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidUnload
{
    [self setTotalIndividual:nil];
    [self setNumeroDePessoas:nil];
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
	[super viewWillDisappear:animated];
}

- (void)viewDidDisappear:(BOOL)animated
{
	[super viewDidDisappear:animated];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}

- (IBAction)calcular:(id)sender
{
    float t = [self.totalIndividual.text floatValue];
    int n = [self.numeroDePessoas.text intValue];
    
    NFPCalc *nfpCalc = [NFPCalc new];
    int resultado = [nfpCalc calculateForTodayWithIndividualValue:t andNumberOfPeople:n];
    

    NSString *message = [[NSString alloc] initWithFormat:@"%d", resultado];
    
    UIAlertView *alert = [[UIAlertView alloc]
                          initWithTitle: @"Resultado do Sorteio"
                          message: message
                          delegate: nil
                          cancelButtonTitle:@"OK"
                          otherButtonTitles:nil];
    [alert show];
}
@end

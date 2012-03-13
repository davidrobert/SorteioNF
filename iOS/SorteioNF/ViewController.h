//
//  ViewController.h
//  SorteioNF
//
//  Created by ios2534 on 13/03/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
@property (weak, nonatomic) IBOutlet UITextField *totalIndividual;
@property (weak, nonatomic) IBOutlet UITextField *numeroDePessoas;
- (IBAction)calcular:(id)sender;

@end

#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	int number, total_num, num_of_num;
	ifstream inputfile; // read file 
	num_of_num = 0;
	total_num = 0;

	inputfile.open("random.txt");

	if (inputfile)
	{
		while (inputfile >> number) // input number from inputfile
		{
			cout << "Now number is : " << number << endl; // show the number
			num_of_num += 1; // count number of numbers
			total_num += number; // get the sum of numbers
		}
		cout << "The number of numbers are : " << num_of_num << endl; //output
		cout << "The Sum of number is : " << total_num << endl; //output
		cout << "The average of number is : " << total_num / num_of_num << endl; //output
	}
	else
		cout << "Error, to input file..." << endl;
	system("pause");
	return 0;

	

		
}
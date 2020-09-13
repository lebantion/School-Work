#include <iostream>

using namespace std;

int main()
{
	double Ocean_level = 0;
	int years;
	for (years = 0; years < 26; years++) // use loop to show 25 years ocean level
	{
		cout <<  years << " year's ocean level is : " << Ocean_level << endl; 
		Ocean_level += 1.5; // add 1.5 every year to output 1.5 gap for ocean level
	}
	system("pause");
	return 0;
}
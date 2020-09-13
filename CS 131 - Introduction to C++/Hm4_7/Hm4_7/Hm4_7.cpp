#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
	ifstream inputfile;
	inputfile.open("People.txt");
	string star;

	int year = 1900, People = 0, multiply, stars;

	cout << "each * represents 1,000 people " << endl;

	for (year = 1900; year <= 2000; year += 20) // to show year 20 year interval until 2000.
	{
		star = ""; // reset star.
		inputfile >> People;  // input value
		multiply = People / 1000; // get how many star do program output
		for (stars = 1; stars <= multiply ; stars++) // use for to set the star for making chart
		{
			star += "*";
		}
		cout << year << " : " << star << endl; // output
	}
	system("pause");
	return 0;
}
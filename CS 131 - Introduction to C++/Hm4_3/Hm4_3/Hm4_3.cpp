#include <iostream>
#include <string>
using namespace std;

int main()
{
	string square;
	int lengths, length;
	square = "";

	cout << "How many length do you want to make? : "; // set the length for square
	cin >> length;

	while (length < 0 || length > 15) // making sure that user put available value for length
	{
		cout << "You cannot put negative value of length and over than 15" << endl;
		cout << "Please, Put right number" << endl;
		cin >> length;
	}

	for (lengths = 0; lengths < length; lengths++) // add X to make square's length which user want to make
	{
		square += "X";
	}
	
	for (lengths = 0; lengths < length; lengths++) // use loop to output vertical length
	{
		cout << square << endl;
	}

	system("pause");
	return 0;
}
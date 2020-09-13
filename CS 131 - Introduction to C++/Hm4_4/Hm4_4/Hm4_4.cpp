#include <iostream>
#include <string>
#include <cmath>
#include <iomanip>

using namespace std;

int main()
{
	string star = "*";
	int line;
	for (line = 0; line < 6; line++) // use loop to show the star;
	{
		cout << setw(6 + line) << star << endl;
		star += "**";
	}
	system("pause");
	return 0;
}
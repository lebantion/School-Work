#include <iostream>

using namespace std;

int main()
{
	const int SIZE = 4;
	char* seasons[SIZE] = { "Spring", "Summer"
							"Fall", "Winter" };

	cout << seasons;
	cout << seasons[3] << endl;
	cout << *seasons[3] << endl;
	cout << *(seasons + 3) << endl;

	system("pause");
	return 0;
}
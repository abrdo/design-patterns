#include "user.h"
#include "topic.h"

#include <string>
#include <iostream>
#include <vector>
using namespace std;



class Dispacher{
    static Dispacher* _instance;
    vector<User*> users;
    vector<Topic*> topics;
protected:
    Dispacher(){
        for(string name : {"Kate", "Steve", "John", "Sam", "Mike"}){
            users.push_back(new User(name));
        }
        for(string name : {"Sport", "Science", "Culture"}){
            topics.push_back(new Topic(name));
        }
    }
public:
    static Dispacher* Instance(){
        if(_instance == 0){
            _instance = new Dispacher;
        }
        return _instance;
    }

    void subscribe(string puser, string ptopic){
        // Search user
        User* user = 0;
        for(auto u : users){
            if(u->get_name() == puser){
                user = u;
            }
        }
        if(user == 0){
            cerr << puser << " is not a valid user."<<endl;
            return;
        }

        // Search topic
        Topic* topic = 0;
        for(auto t : topics){
            if(t->get_name() == ptopic){
                topic = t;
            }
        }
        if(topic == 0){
            cerr << ptopic << " is not a valid topic."<<endl;
            return;
        }

        // Subscribe process
        topic->attach(user);
        user->subscribe(*topic);

    }

    void send_message(/*string psender,*/ string ptopic, string message){ // in this representation the sender parameter doesn't make sense
        // Search topic
        Topic* topic = 0;
        for(auto t : topics){
            if(t->get_name() == ptopic){
                topic = t;
            }
        }
        if(topic == 0){
            cerr << ptopic << " is not a valid topic."<<endl;
            return;
        }

        // Sending
        topic->set_message(message);
    }

};
Dispacher* Dispacher::_instance = 0;

int main(){
    Dispacher* disp = Dispacher::Instance(); // user and topic names hard-coded in the constructor
    disp->subscribe("Kate", "Culture");
    disp->subscribe("Steve", "Culture");
    disp->subscribe("Sam", "Culture");
    disp->subscribe("Sam", "Science");
    disp->subscribe("John", "Science"); // Mike is not subscribed for anything and it doesn't crash.
                                        // For Sport there is no subscriber, but it doesn't crash.

    Dispacher* disp2 = Dispacher::Instance(); // it will be equal to disp (by reference), because disp is a singleton.
    disp2->send_message("Culture", "theatre tomorrow evening");
    disp2->send_message("Science", "new invention!");
    disp2->send_message("Sport", "FC Barcelona - Real Madrid 2:2");


    return 0;
}





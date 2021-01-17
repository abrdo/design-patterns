#ifndef USER_H
#define USER_H

#include "observer.h"
#include "topic.h"

#include <iostream>
#include <string>
using namespace std;


class User : public Observer
{
    std::string name;
    std::vector<Topic> mytopics;
public:
    User(std::string pname) : name(pname) {}

    std::string get_name(){ return name; }

    void subscribe(Topic t){
        mytopics.push_back(t);
    }

    void update(std::string topic_nameU, std::string messageU) override {
        for(Topic &myt : mytopics){
            if(myt.get_name() == topic_nameU){
                myt.set_message(messageU, false);
                std::cout<< this->name << "\t" << myt.get_name() << "\t'" << myt.get_message() << "'" << std::endl;
                return;
            }
        }
        std::cerr<< "Warning:  " << this->name << " is not subscribed to this topic: " << topic_nameU << ". But he/she is in the topic's subscriber list." << std::endl;
    }

    void print_data(){
        std::cout<<name<<":\t";
        for(Topic myt : mytopics){
            std::cout<<myt.get_name()<<"\t";
        }
        std::cout<<std::endl;
    }
};

#endif // USER_H

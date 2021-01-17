#ifndef TOPIC_H
#define TOPIC_H

#include "subject.h"
#include "string"


class Topic : public Subject
{
    std::string name;
    std::string message;
public:
    Topic(std::string pname) : name(pname), message(""){}
    std::string get_name(){ return name; }
    std::string get_message(){ return message; }
    void set_message(std::string m, bool with_update = true){
        message = m;
        if(with_update){
            for(Observer* u : subscribers){
                u->update(this->name, this->message);
            }
        }
    }

    void notfify() override {
        for(Observer* s : subscribers){
            s->update(this->name, this->message);
        }
    }

};

#endif // TOPIC_H

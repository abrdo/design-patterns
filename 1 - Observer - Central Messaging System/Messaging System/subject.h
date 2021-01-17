#ifndef SUBJECT_H
#define SUBJECT_H

#include "observer.h"

#include <vector>
#include <string>

class Subject
{
protected:
    std::vector<Observer*> subscribers;
public:
    Subject(){}

    void attach(Observer* new_subs){
        subscribers.push_back(new_subs);
    }
    virtual void notfify() = 0;


};

#endif // SUBJECT_H

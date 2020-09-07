
# An SMS Simluation class SMSMessage(object):
"""
    You are on the right track just misisnig few bits here and there
    the code logic is clear 
    What differentiates methods from functions is that methods belong to a class
    therefore you need to define your methods inside the class SMSMessage

"""
class SMSMessage:
    
    def __init__(self, hasBeenRead, messageText, fromNumber):
        self.hasBeenRead = False
        self.text = messageText   # assign values to object properties using __init__ parameters
        self.number = fromNumber  # property names do not have to match method parameters   

    """
        if the method needs acces to class properties, we pass self to the method as an argument
        inside the methode self.propertyname gives access to property values
    """

    def add_sms(self):
        #add message to SMSStore
        print("hitting add sms method")  # the print() is only to help with debugging, can be removed later
        SMSStore.append(self)
    
    def get_count():
        # count messages in the SMSStore
        print("count messages")

    def get_message():
        # get message to be read, 
        print("get message method")

    def get_unread_message():
        # get all unread messages, with hasBeenRead = False
        print("get unread messages method")

    def remove():
        # remove message from SMSStore
        print("remove message method")

    def send_message(self):
        #add message to send messages
        sendItems.append(self)

# recommend defining your storage elements before any code logic 
SMSStore = []
sendItems = []

# SMS objects
no_1 = SMSMessage(False, "Hello", "0798653452")
no_2 = SMSMessage(False, "You missed a call from 10111", "0845673864")
no_3 = SMSMessage(False, "How are you", "0631873298")

#now with your class methods defined you can call them from anywhere in you code
# access to methods is through object.method() e.g no_1.add_sms() 

userChoice = ""
while userChoice != "quit" :
    userChoice = input("What would you like to do - read/send/qauit?")
    # Uncomment raw_input for python --verion below version 3.x
    # userChoice = raw_input("What would you like to do - read/send/qauit?")
   
    if userChoice == "read":
        print("Goodbye")

    elif userChoice == "send":
        message = input("Type the message you wish to send: ")
        toNumber = input("Enter numbers to send to: ")
        # send message to the given number, the message will appear in sendItems 
        SMSMessage( False, message, toNumber).send_message()
        print("\nSend: ",sendItems[len(sendItems)-1].text)
        print("To: ",sendItems[len(sendItems)-1].number)
    else: 
        print("Opps - incorrect input")
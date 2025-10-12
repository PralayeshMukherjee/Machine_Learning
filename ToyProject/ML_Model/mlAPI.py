from flask import Flask,request,jsonify;
import pickle;

app = Flask(__name__);# creatae the instance of the flask web appliction object

# load the model
with open('model.pkl','rb') as file:
    model = pickle.load(file);
# the open function open the model.pkl file and read it in binary mode
# the with...as file is a context manager that ensures that the file is properly closed automatically after the code block is executed
# the opened file object is assigend to the variable 'file'
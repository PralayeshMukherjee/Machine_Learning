from flask import Flask,request,jsonify;
import pickle;

app = Flask(__name__);# creatae the instance of the flask web appliction object

# load the model
with open('model.pkl','rb') as file:
    model = pickle.load(file);
# the open function open the model.pkl file and read it in binary mode
# the with...as file is a context manager that ensures that the file is properly closed automatically after the code block is executed
# the opened file object is assigend to the variable 'file'

@app.route('/predict',methods=['POST'])
def predict():
    data = request.get_json();
    iq = data.get('iq')
    cgpa = data.get('cgpa')
    features = np.array([[iq,cgpa]]);
    prediction = model.predict(features);
    return jsonify({'prediction' : int(prediction[0])});
#create a fucntion names predict 
first line means it extracts a specific piece of information from the received data 
second & third line I get the data fomr the json object and store it in local variables
in the fourth line I convert the input data into a numpy array and reshape it to match the input format expected by the model
in fifth line I use the loaded model to make a prediction based on the iput features
in the last line I return the prediction result as a json response
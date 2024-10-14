from flask import Flask, request, jsonify
from analysis import analyze_tasks

app = Flask(__name__)

@app.route('/analyze', methods=['POST'])
def analyze():
    tasks = request.json.get('tasks')
    analysis_result = analyze_tasks(tasks)
    return jsonify(analysis_result)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)

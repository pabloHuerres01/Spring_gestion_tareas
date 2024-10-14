def analyze_tasks(tasks):
    # Aquí va tu lógica de análisis
    # Por ejemplo, contar tareas, categorizarlas, etc.
    result = {
        "total_tasks": len(tasks),
        "completed": sum(1 for task in tasks if task['status'] == 'completed'),
        "pending": sum(1 for task in tasks if task['status'] == 'pending'),
    }
    return result

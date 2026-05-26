import matplotlib.pyplot as plt
import numpy as np

# Generate some random data
np.random.seed(42)
x = np.random.rand(50)
y = np.random.rand(50)
colors = np.random.rand(50)
areas = np.random.rand(50) * 100

# Create a scatter plot
plt.figure(figsize=(8, 6))
plt.scatter(x, y, s=areas, c=colors, alpha=0.7, cmap='viridis')

# Add labels and title
plt.xlabel("X-axis")
plt.ylabel("Y-axis")
plt.title("Sample Scatter Plot")
plt.colorbar(label='Color intensity')
plt.grid(True)
plt.show()
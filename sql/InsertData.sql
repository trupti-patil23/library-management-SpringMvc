INSERT INTO Book (title, author, isbn, status) VALUES
('Effective Java', 'Joshua Bloch', '9780134685991', 'Available'),
('Clean Code', 'Robert C. Martin', '9780132350884', 'Available'),
('The Pragmatic Programmer', 'Andrew Hunt', '9780201616224', 'Borrowed'),
('Head First Design Patterns', 'Eric Freeman', '9780596007126', 'Available');

-- Sample Data Insertion for Student Table
INSERT INTO Student (name, email, password, overdue_status) VALUES
('John Doe', 'john.doe@example.com', 'password123', FALSE),
('Jane Smith', 'jane.smith@example.com', 'password456', TRUE),
('Mike Johnson', 'mike.johnson@example.com', 'password789', FALSE);

-- Sample Data Insertion for Librarian Table
INSERT INTO Librarian (name, email, password) VALUES 
('Alice Brown', 'alice.brown@example.com', 'librarianpass1'),
('Bob Martin', 'bob.martin@example.com', 'librarianpass2');
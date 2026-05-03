# Rental Management System

A comprehensive Java-based rental management application with GUI bill receipts, user authentication, and support for multiple rental categories.

## Features

- 🔐 **User Registration & Login** - Secure authentication system for new and existing users
- 📚 **Multiple Rental Categories**:
  - Books
  - Vehicles
  - Clothes
  - Electronics
  - Rooms
- 🧾 **GUI Bill Receipts** - Professional bill receipts with dates and costs
- 📅 **Date Tracking** - Track take and return dates for all rentals
- ✅ **Return Management** - Remove returned items from receipts
- 📊 **Availability Display** - Real-time availability status for all items
- 🎨 **ASCII Art Headers** - Beautiful ASCII art for each rental category

## Project Structure

```
Rental Management System/
├── MainApp.java           # Main application with login/registration
├── User.java             # User model with authentication
├── BookRental.java       # Book rental management
├── VehicleRental.java    # Vehicle rental management
├── ClothesRental.java    # Clothes rental management
├── ElectronicsRental.java # Electronics rental management
├── RoomsRental.java      # Room rental management
└── BillReceipt.java      # GUI bill receipt generator
```

## Getting Started

### Prerequisites
- Java 8 or higher
- Git

### Installation

1. Clone the repository:
```bash
git clone https://github.com/Tharun929/Rental-Management-System.git
cd Rental-Management-System
```

2. Compile the project:
```bash
javac *.java
```

3. Run the application:
```bash
java MainApp
```

## Usage

1. **Register/Login**: Choose to register a new account or login with existing credentials
2. **Select Category**: Choose from Books, Vehicles, Clothes, Electronics, or Rooms
3. **View Items**: Browse available items in the selected category
4. **Rent Items**: Select items and specify rental duration
5. **View My Rentals**: Check your active rentals with dates and costs
6. **Return Items**: Return items and automatically remove them from receipts

## How to Contribute

### Setting Up Development Environment

1. Fork the repository
2. Clone your fork:
```bash
git clone https://github.com/YOUR_USERNAME/Rental-Management-System.git
```

3. Create a feature branch:
```bash
git checkout -b feature/your-feature-name
```

4. Make your changes and test them
5. Commit your changes:
```bash
git add .
git commit -m "Add your descriptive commit message"
```

6. Push to your fork:
```bash
git push origin feature/your-feature-name
```

7. Create a Pull Request on GitHub

### Contribution Guidelines

- Keep commits atomic and focused
- Write clear commit messages
- Test your changes before pushing
- Follow existing code style and naming conventions
- Update documentation if needed
- Exclude compiled files (.class) and IDE files from commits

### Areas for Contribution

- ✨ Add new rental categories
- 🔒 Enhance security features
- 💾 Add database persistence
- 🎨 Improve UI/UX
- 📱 Add mobile compatibility
- 🧪 Write unit tests
- 📖 Improve documentation

## File Description

| File | Purpose |
|------|---------|
| `MainApp.java` | Entry point with user authentication and main menu |
| `User.java` | User model with login/registration encapsulation |
| `BookRental.java` | Book rental operations with ASCII art header |
| `VehicleRental.java` | Vehicle rental with car ASCII art display |
| `ClothesRental.java` | Clothes rental management |
| `ElectronicsRental.java` | Electronics rental with appliance ASCII art |
| `RoomsRental.java` | Room/accommodation rental with building ASCII art |
| `BillReceipt.java` | Swing GUI for displaying rental bills with dates |

## Technical Stack

- **Language**: Java SE
- **GUI Framework**: Swing
- **Data Structures**: ArrayList, Arrays
- **Date/Time**: LocalDateTime, DateTimeFormatter
- **Authentication**: Custom encapsulated User class

## Future Enhancements

- [ ] Add database (MySQL/PostgreSQL) for persistent storage
- [ ] Implement user profile management
- [ ] Add email notifications
- [ ] Create admin dashboard
- [ ] Add payment gateway integration
- [ ] Implement search and filtering
- [ ] Add user reviews and ratings
- [ ] Mobile app support

## License

This project is open source and available under the MIT License.

## Contact

For questions or suggestions, please open an issue on GitHub or contact the maintainer.

---

**Happy Contributing! 🎉**

# Contributing to Rental Management System

We welcome contributions from the community! This document provides guidelines and instructions for contributing.

## Code of Conduct

- Be respectful and inclusive
- Help others learn and grow
- Focus on constructive feedback
- Report issues professionally

## How to Contribute

### Reporting Bugs

1. Check if the bug has already been reported in Issues
2. If not, create a new issue with:
   - Clear title describing the bug
   - Detailed description of the problem
   - Steps to reproduce
   - Expected behavior
   - Actual behavior
   - Screenshots (if applicable)

### Suggesting Features

1. Check existing Issues and Discussions first
2. Create a new issue with:
   - Clear title
   - Description of the feature
   - Use cases and benefits
   - Possible implementation approaches
   - Examples of similar features

### Pull Request Process

1. **Fork the repository** on GitHub
2. **Create a feature branch**:
   ```bash
   git checkout -b feature/feature-name
   ```
3. **Make your changes**:
   - Follow existing code style
   - Keep commits atomic and focused
   - Add comments for complex logic
   - Test your changes thoroughly

4. **Compile and test**:
   ```bash
   javac *.java
   java MainApp
   ```

5. **Commit with clear messages**:
   ```bash
   git commit -m "Add feature: description of what you added"
   git commit -m "Fix: description of bug fix"
   git commit -m "Refactor: description of improvements"
   ```

6. **Push to your fork**:
   ```bash
   git push origin feature/feature-name
   ```

7. **Create a Pull Request**:
   - Compare across forks
   - Write a clear PR description
   - Link any related issues
   - Wait for review and feedback

## Code Style Guidelines

### Java Conventions

```java
// Class names: PascalCase
public class UserAuthentication {
    
    // Constants: UPPER_CASE
    private static final int MAX_USERS = 100;
    
    // Methods and variables: camelCase
    private String userPassword;
    
    public void validateUserInput() {
        // Implementation
    }
}
```

### Naming Conventions

- Classes: `PascalCase` (e.g., `BookRental`, `UserManager`)
- Methods: `camelCase` (e.g., `registerUser`, `validatePassword`)
- Variables: `camelCase` (e.g., `userName`, `rentalCost`)
- Constants: `UPPER_CASE` (e.g., `MAX_RENTAL_DAYS`)

### Documentation

- Add JavaDoc comments for public methods
- Add inline comments for complex logic
- Update README.md if adding new features

```java
/**
 * Validates user password strength
 * @param password the password to validate
 * @return true if password meets security requirements
 */
public boolean validatePassword(String password) {
    // Implementation
}
```

## Git Workflow

### Branch Naming

- `feature/description` - New features
- `fix/description` - Bug fixes
- `refactor/description` - Code improvements
- `docs/description` - Documentation updates

### Commit Messages

**Format**: `[Type]: Brief description`

Examples:
```
[Feature]: Add payment gateway integration
[Fix]: Correct date formatting in bill receipt
[Refactor]: Improve user authentication logic
[Docs]: Update installation instructions
[Test]: Add unit tests for UserClass
```

## Testing

Before submitting a PR:

1. **Compile successfully**:
   ```bash
   javac *.java
   ```

2. **Test manually**:
   - Run the application
   - Test your new feature
   - Verify existing features still work
   - Test edge cases

3. **Check for common issues**:
   - Memory leaks
   - Null pointer exceptions
   - Input validation

## Getting Help

- Check existing documentation in README.md
- Look at similar implementations in the codebase
- Open an issue with the `question` label
- Comment on related discussions

## Recognition

Contributors will be acknowledged in:
- GitHub Contributors page
- README.md contributors section
- Release notes

## License

By contributing, you agree that your contributions will be licensed under the MIT License.

---

Thank you for contributing to make this project better! 🚀

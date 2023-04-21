#include "mainwidget.h"

MainWidget::MainWidget(QWidget *parent)
    : QWidget(parent)
{
    // Initialize the objects
    label = new QLabel("Enter your information:");
    lineEditFirstName = new QLineEdit();
    lineEditLastName = new QLineEdit();
    spinBoxAge = new QSpinBox();
    spinBoxAge->setRange(0, 120);
    radioButtonMale = new QRadioButton("Male");
    radioButtonFemale = new QRadioButton("Female");
    finishButton = new QPushButton("Finish");
    textEdit = new QTextEdit();
    genderGroupBox = new QGroupBox("Gender");
    refreshButton = new QPushButton("Refresh");

    QVBoxLayout *verticalLayout = setVerticalLayout();
    setLayout(verticalLayout);

    // Connect the clicked signal of the finish button to the fillSummary() slot function
    connect(finishButton, &QPushButton::clicked, this, &MainWidget::fillSummary);
    // Connect the clicked signal of the refresh button to the refresh() slot function
    connect(refreshButton, &QPushButton::clicked, this, &MainWidget::refresh);
}

MainWidget::~MainWidget()
{
}

QVBoxLayout *MainWidget::setVerticalLayout()
{
    QVBoxLayout *verticalLayout = new QVBoxLayout;
    QGridLayout *gridLayout = setGridLayout();

    verticalLayout->addLayout(gridLayout); // Use addLayout() instead of addItem()
    return verticalLayout;
}

QGridLayout *MainWidget::setGridLayout()
{
    QGridLayout *gridLayout = new QGridLayout;

    // Set up the layout for radio buttons
    QVBoxLayout *genderRadioButtonLayout = new QVBoxLayout;
    genderRadioButtonLayout->addWidget(radioButtonMale);
    genderRadioButtonLayout->addWidget(radioButtonFemale);
    genderGroupBox->setLayout(genderRadioButtonLayout);

    // Add widgets to the grid layout using addWidget()
    gridLayout->addWidget(label, 0, 0);
    gridLayout->addWidget(new QLabel("First Name:"), 1, 0);
    gridLayout->addWidget(lineEditFirstName, 1, 1);
    gridLayout->addWidget(new QLabel("Last Name:"), 2, 0);
    gridLayout->addWidget(lineEditLastName, 2, 1);
    gridLayout->addWidget(new QLabel("Age:"), 3, 0);
    gridLayout->addWidget(spinBoxAge, 3, 1);
    gridLayout->addWidget(genderGroupBox, 4, 0, 1, 2);
    gridLayout->addWidget(textEdit, 5, 0, 1, 2);
    gridLayout->addWidget(finishButton, 6, 1);
    gridLayout->addWidget(refreshButton, 6, 0);

    return gridLayout;
}
void MainWidget::fillSummary()
{
    QString firstName = lineEditFirstName->text();
    QString lastName = lineEditLastName->text();
    int age = spinBoxAge->value();
    QString gender = radioButtonMale->isChecked() ? "Male" : "Female";

    QString summary = QString("First Name: %1\nLast Name: %2\nAge: %3\nGender: %4")
                          .arg(firstName)
                          .arg(lastName)
                          .arg(age)
                          .arg(gender);

    textEdit->setText(summary);

    // Clear the widgets
    lineEditFirstName->clear();
    lineEditLastName->clear();
    spinBoxAge->clear(); // Note: This will set the value to the minimum value (0 in this case)
    radioButtonMale->setChecked(false);
    radioButtonFemale->setChecked(false);
    textEdit->setText(summary);
}

void MainWidget::refresh()
{
    lineEditFirstName->clear();
    lineEditLastName->clear();
    spinBoxAge->clear(); // Note: This will set the value to the minimum value (0 in this case)
    radioButtonMale->setChecked(false);
    radioButtonFemale->setChecked(false);
    textEdit->clear();
}


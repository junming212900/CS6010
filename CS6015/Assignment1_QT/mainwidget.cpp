#include "mainwidget.h"

mainwidget::mainwidget(QWidget *parent)
    : QWidget(parent)
{
    inputLabel = new QLabel("Enter expression:");
    inputTextEdit = new QTextEdit();
    Subimt = new QPushButton("Submit");
    reset = new QPushButton("Reset");
    radioButtonInterp = new QRadioButton("Interpret");
    radioButtonPrettyPrint = new QRadioButton("Pretty Print");
    outputLabel = new QLabel("Result:");
    outputTextEdit = new QTextEdit();
    outputTextEdit->setReadOnly(true);

    QVBoxLayout *verticalLayout = setMainLayout();
    setLayout(verticalLayout);

    // Connect the clicked signal of the submit button to the parseAndEvaluate() slot function
    connect(Subimt, &QPushButton::clicked, this, &mainwidget::parseAndEvaluate);
    // Connect the clicked signal of the reset button to the readFromFile() slot function
    connect(reset, &QPushButton::clicked, this, &mainwidget::parseAndEvaluate);
}

mainwidget::~mainwidget()
{
}

QVBoxLayout *mainwidget::setMainLayout()
{
    QVBoxLayout *mainLayout = new QVBoxLayout;

    QHBoxLayout *optionsLayout = new QHBoxLayout;
    optionsLayout->addWidget(radioButtonInterp);
    optionsLayout->addWidget(radioButtonPrettyPrint);

    mainLayout->addWidget(inputLabel);
    mainLayout->addWidget(inputTextEdit);
    mainLayout->addLayout(optionsLayout);
    mainLayout->addWidget(Subimt);
    mainLayout->addWidget(reset);
    mainLayout->addWidget(outputLabel);
    mainLayout->addWidget(outputTextEdit);

    return mainLayout;
}

void mainwidget::parseAndEvaluate()
{
    // Get the input expression from the inputTextEdit
    QString input_str = inputTextEdit->toPlainText();
    std::string str_to_be_parsed = input_str.toUtf8().constData();

    // Parse the expression
    PTR(Expr) e;
    try {
        e = parse_str(str_to_be_parsed);
    } catch (std::runtime_error &err) {
        outputTextEdit->setPlainText("Invalid expression. Please check your input.");
        return;
    }

    // Check which radio button is selected and perform the corresponding action
    if (radioButtonInterp->isChecked()) {
        // Interp
        PTR(Env) env = NEW(EmptyEnv)();
        PTR(VAL) val = e->interp(env);
        QString result_to_display = QString::fromStdString(val->to_string());
        outputTextEdit->setPlainText(result_to_display);
    } else if (radioButtonPrettyPrint->isChecked()) {
        // PrettyPrint
        std::string result_str = e->pretty_print_at_to_string();
        QString result_to_display = QString::fromStdString(result_str);
        outputTextEdit->setPlainText(result_to_display);
    } else {
        outputTextEdit->setPlainText("Please select either Interp or Pretty Print.");
    }
}

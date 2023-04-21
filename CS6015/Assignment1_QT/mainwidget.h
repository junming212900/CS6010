#ifndef MAINWIDGET_H
#define MAINWIDGET_H

#include <QWidget>
#include <QLabel>
#include <QLineEdit>
#include <QPushButton>
#include <QTextEdit>
#include <QVBoxLayout>
#include <QHBoxLayout>
#include <QGridLayout>
#include <QSpacerItem>
#include <QFileDialog>
#include <QRadioButton>
#include "Expr.h"
#include "parse.h"
#include "VAL.h"
#include "Env.h"
#include "pointer.h"

class mainwidget : public QWidget
{
    Q_OBJECT

public:
    mainwidget(QWidget *parent = nullptr);
    ~mainwidget();

private slots:
    void parseAndEvaluate(); // Slot function to parse and evaluate the MSDscript expression


private:
    QLabel *inputLabel;
    QTextEdit *inputTextEdit; // Widget for the user to enter an expression
    QPushButton *Subimt;
    QPushButton *reset;// Button to parse and evaluate the expression
    QRadioButton *radioButtonInterp;
    QRadioButton *radioButtonPrettyPrint;
    QLabel *outputLabel;
    QTextEdit *outputTextEdit; // Widget to display the output
    QVBoxLayout *setMainLayout();
};
#endif // MAINWIDGET_H


#ifndef MAINWIDGET_H
#define MAINWIDGET_H

#include <QWidget>
#include <QLabel>
#include <QLineEdit>
#include <QDialogButtonBox>
#include <QRadioButton>
#include <QPushButton>
#include <QTextEdit>
#include <QVBoxLayout>
#include <QHBoxLayout>
#include <QGridLayout>
#include <QGroupBox>
#include <QSpacerItem>
#include <QSpinBox>

class MainWidget : public QWidget
{
    Q_OBJECT

public:
    MainWidget(QWidget *parent = nullptr);
    ~MainWidget();

private slots:
    void fillSummary();
    void refresh();

private:
    QLabel *label;
    QLineEdit *lineEditFirstName;
    QLineEdit *lineEditLastName;
    QSpinBox *spinBoxAge;
    QRadioButton *radioButtonMale;
    QRadioButton *radioButtonFemale;
    QPushButton *finishButton;
    QPushButton *refreshButton;
    QTextEdit *textEdit;
    QGroupBox *genderGroupBox;

    QVBoxLayout *setVerticalLayout();
    QGridLayout *setGridLayout();
};

#endif // MAINWIDGET_H

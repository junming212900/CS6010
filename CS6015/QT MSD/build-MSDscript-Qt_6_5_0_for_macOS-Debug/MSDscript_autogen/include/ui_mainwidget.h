/********************************************************************************
** Form generated from reading UI file 'mainwidget.ui'
**
** Created by: Qt User Interface Compiler version 6.5.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWIDGET_H
#define UI_MAINWIDGET_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_mainWidget
{
public:
    QWidget *centralwidget;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *mainWidget)
    {
        if (mainWidget->objectName().isEmpty())
            mainWidget->setObjectName("mainWidget");
        mainWidget->resize(800, 600);
        centralwidget = new QWidget(mainWidget);
        centralwidget->setObjectName("centralwidget");
        mainWidget->setCentralWidget(centralwidget);
        menubar = new QMenuBar(mainWidget);
        menubar->setObjectName("menubar");
        mainWidget->setMenuBar(menubar);
        statusbar = new QStatusBar(mainWidget);
        statusbar->setObjectName("statusbar");
        mainWidget->setStatusBar(statusbar);

        retranslateUi(mainWidget);

        QMetaObject::connectSlotsByName(mainWidget);
    } // setupUi

    void retranslateUi(QMainWindow *mainWidget)
    {
        mainWidget->setWindowTitle(QCoreApplication::translate("mainWidget", "mainWidget", nullptr));
    } // retranslateUi

};

namespace Ui {
    class mainWidget: public Ui_mainWidget {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWIDGET_H

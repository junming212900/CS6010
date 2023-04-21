#ifndef MAINWIDGET_H
#define MAINWIDGET_H

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui { class mainWidget; }
QT_END_NAMESPACE

class mainWidget : public QMainWindow
{
    Q_OBJECT

public:
    mainWidget(QWidget *parent = nullptr);
    ~mainWidget();

private:
    Ui::mainWidget *ui;
};
#endif // MAINWIDGET_H

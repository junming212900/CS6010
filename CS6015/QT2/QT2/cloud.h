#ifndef CLOUD_H
#define CLOUD_H

#include <QObject>
#include <QGraphicsPixmapItem>
#include <QTimer>

class Cloud : public QObject, public QGraphicsPixmapItem
{
    Q_OBJECT
public:
    Cloud();

public slots:
    void move();

private:
    int direction;
    QTimer *timer;
};

#endif // CLOUD_H

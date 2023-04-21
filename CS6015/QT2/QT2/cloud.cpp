#include "cloud.h"
#include <QPixmap>
#include <QTimer>

Cloud::Cloud()
{
    setPixmap(QPixmap(":/images/cloud.png").scaled(400, 400));

    direction = 1;

    timer = new QTimer(this);
    connect(timer, &QTimer::timeout, this, &Cloud::move);
    timer->start(100);
}

void Cloud::move()
{
    if (x() >= 0 && x() <= 500)
    {
        setPos(x() + direction, y());
    }
    else
    {
        direction = -direction;
    }
}

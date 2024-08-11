from typing import List


class Car:
    def __init__(self, position, speed):
        self.position = position
        self.speed = speed


class TimeCalculator:
    def __init__(self, target):
        self.target = target

    def calculate(self, car):
        distance = self.target - car.position
        return distance / car.speed


class FleetTimeStack:
    def __init__(self):
        self.s = []

    def push_greater(self, time):
        if len(self.s) == 0:
            self.s.append(time)
        else:
            lt = self.s[-1]
            if time > lt:
                self.s.append(time)

    def __len__(self):
        return len(self.s)


class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        tc = TimeCalculator(target)

        cars = []
        for p, s in zip(position, speed):
            cars.append(Car(p, s))

        cars.sort(key=lambda c: (c.position, c.speed), reverse=True)

        fts = FleetTimeStack()
        for c in cars:
            t = tc.calculate(c)
            fts.push_greater(t)

        return len(fts)

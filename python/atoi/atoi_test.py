import unittest
import atoi


class MyTest(unittest.TestCase):
    def test(self):
        self.assertEqual(atoi.atoi("abc"), 123)

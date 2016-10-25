main = print $ (sqrt_n 0)

sqrt_n num | num < 0   = (-1) -- undefined throws exception
           | otherwise = sqrtInternal num (num * 0.5)

sqrtInternal num result | abs (num - result * result) > abs(num * 0.000001) = sqrtInternal num curVal
                        | otherwise                                         = result
             where curVal = (result + num / result) * 0.5

sum_digits num | num > 0   = (num `mod` 10) + sum_digits (num `div` 10)
               | num < 0   = sum_digits (-num)
               | otherwise = 0

count_digits num = digitsCountInternal (abs(num) `div` 10)

digitsCountInternal num | num > 0   = 1 + digitsCountInternal (abs(num) `div` 10)
                        | otherwise = 1
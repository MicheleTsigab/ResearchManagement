from django.db import models
from django.contrib.auth.models import User
class Staff(models.Model):
    id=models.AutoField(primary_key=True)
    first_name=models.CharField(max_length=150)
    last_name=models.CharField(max_length=150)
    phone=models.CharField(max_length=30,default="09000000",null=True)
    password=models.CharField(max_length=128)
    email=models.CharField(max_length=254)
    last_login=models.DateField()
    is_active=models.BooleanField()
    date_joined=models.DateField()
    class Meta:
        db_table = "staff"

